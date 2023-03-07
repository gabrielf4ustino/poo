package br.bootcamp.project.service;

import br.bootcamp.project.dto.DevDTO;
import br.bootcamp.project.model.BootcampModel;
import br.bootcamp.project.model.ContentModel;
import br.bootcamp.project.model.DevModel;
import br.bootcamp.project.repository.BootcampRepository;
import br.bootcamp.project.repository.DevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DevService {

    @Autowired
    private DevRepository devRepository;

    @Autowired
    private BootcampRepository bootcampRepository;

    public boolean persistDev(DevDTO devDTO) {
        try {
            devRepository.save(new DevModel(devDTO.getName(), devDTO.getSubscribedContentModels(), devDTO.getFinishedContentModels()));
        } catch (RuntimeException ignored) {
            return false;
        }
        return true;
    }

    public List<DevDTO> getAll() {
        return devRepository
                .findAll()
                .stream()
                .map(dev -> new DevDTO(dev.getName(), dev.getSubscribedContents(), dev.getFinishedContents()))
                .collect(Collectors.toList());
    }

    public void subscribeBootcamp(String bootcampName, String name) {
        DevModel dev = devRepository.findByName(name);
        BootcampModel bootcamp = bootcampRepository.findByName(bootcampName);
        dev.setSubscribedContents(bootcamp.getContents());
        devRepository.save(dev);
        Set<DevModel> devs = bootcamp.getDevs();
        devs.add(dev);
        bootcamp.setDevs(devs);
        bootcampRepository.save(bootcamp);
    }

    public void progress(String name) {
        DevModel dev = devRepository.findByName(name);
        Set<ContentModel> subscribedContents = dev.getSubscribedContents();
        if (subscribedContents.stream().findFirst().isPresent()) {
            Set<ContentModel> finishedContents = dev.getFinishedContents();
            finishedContents.add(subscribedContents.stream().findFirst().get());
            subscribedContents.remove(subscribedContents.stream().findFirst().get());
            dev.setSubscribedContents(subscribedContents);
            dev.setFinishedContents(finishedContents);
            devRepository.save(dev);
        } else {
            throw new RuntimeException("Você não está matriculado em nenhum conteudo.");
        }

        devRepository.save(dev);
    }

    public double calculateXp(String name){
        return devRepository.findByName(name)
                .getFinishedContents()
                .stream()
                .mapToDouble(ContentModel::calculateXp)
                .sum();
    }
}
