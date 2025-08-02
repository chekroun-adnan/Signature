package com.test.test.Services;

import com.test.test.Entities.Type_Parapheur;
import com.test.test.Repository.TypeParapheurRepository;
import org.springframework.stereotype.Service;

import java.awt.font.OpenType;
import java.util.Optional;

@Service
public class TypeParapheurService {

    private final TypeParapheurRepository typeParapheurRepository;

    public TypeParapheurService(TypeParapheurRepository typeParapheurRepository) {
        this.typeParapheurRepository = typeParapheurRepository;
    }

    public Type_Parapheur createType(Type_Parapheur typeParapheur){
        return typeParapheurRepository.save(typeParapheur);
    }

    public void deleteType(Long type_id){
        Type_Parapheur existingType = typeParapheurRepository.findById(type_id)
                .orElseThrow(()-> new RuntimeException("Type not Found By Id " + type_id));
        typeParapheurRepository.delete(existingType);
    }

    public void updateType(Type_Parapheur typeParapheur){
        if(typeParapheur.getType_id() != null){
            Optional<Type_Parapheur> type = typeParapheurRepository.findById(typeParapheur.getType_id());
            if (type.isPresent()){
                Type_Parapheur existingType = type.get();
                existingType.setDescription(typeParapheur.getDescription());
                existingType.setLibelle(typeParapheur.getLibelle());
                typeParapheurRepository.save(existingType);
            }
        }
    }

    public Optional<Type_Parapheur> getType(Long type_id){
        return typeParapheurRepository.findById(type_id);
    }
}
