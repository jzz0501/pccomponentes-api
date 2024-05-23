package com.pccomponentes.practice.service.opinion;

import com.pccomponentes.practice.dto.OpinionDTO;
import com.pccomponentes.practice.entity.Client;
import com.pccomponentes.practice.entity.Opinion;
import com.pccomponentes.practice.entity.Product;
import com.pccomponentes.practice.mapper.OpinionMapper;
import com.pccomponentes.practice.repository.ClientRepo;
import com.pccomponentes.practice.repository.OpinionRepo;
import com.pccomponentes.practice.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OpinionService implements iOpinionService{

    @Autowired
    OpinionRepo opinionRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ClientRepo clientRepo;

    @Override
    public List<OpinionDTO> findAllOpinionOfProduct(Long id_product) {
        List<Opinion> opinionDTOS = opinionRepo.findByProductID(id_product);
        return OpinionMapper.mapToOpinionDTOList(opinionDTOS);
    }

    @Override
    public Boolean addOpinionOfProduct(Long id_product, Long id_client, Map<String, String> comments) {

        Optional<Product> product = productRepo.findById(id_product);
        if (product.isEmpty()) return false;
        Optional<Client> client = clientRepo.findById(id_client);
        if (client.isEmpty()) return false;

        String comment = comments.get("comment");
        Integer score = Integer.valueOf(comments.get("score"));

        Opinion opinion = new Opinion();
        opinion.setClient(client.get());
        opinion.setProduct(product.get());
        opinion.setComment(comment);
        opinion.setScore(score);
        opinion.setCreatedDate(LocalDate.now().toString());

        opinionRepo.save(opinion);

        return true;
    }

    @Override
    public Boolean removeOpinionOfProduct(Long id_opinion) {
        opinionRepo.deleteById(id_opinion);
        return true;
    }

}
