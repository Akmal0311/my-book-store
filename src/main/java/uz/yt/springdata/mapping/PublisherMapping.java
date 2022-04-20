package uz.yt.springdata.mapping;

import uz.yt.springdata.dao.Publisher;
import uz.yt.springdata.dto.PublisherDTO;

public class PublisherMapping {

    public static PublisherDTO toDTO(Publisher publisher){
        return new PublisherDTO(publisher.getId(),
                publisher.getName(),
                publisher.getAddId());
    }

    public static Publisher toEntity(PublisherDTO publisherDTO){
        return new Publisher(publisherDTO.getId(),
                publisherDTO.getName(),
                publisherDTO.getAddressId());
    }

    public static void setEntity(Publisher publisher, PublisherDTO publisherDTO){
        publisher.setId(publisherDTO.getId());
        publisher.setName(publisherDTO.getName());
        publisher.setAddId(publisherDTO.getAddressId());
    }
}
