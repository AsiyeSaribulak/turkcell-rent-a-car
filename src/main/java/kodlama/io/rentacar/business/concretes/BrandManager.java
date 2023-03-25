package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.entities.concretes.Brand;
import kodlama.io.rentacar.repository.abstracts.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getById(int id) {
        checkIfBrandExists(id);
        return brandRepository.findById(id).orElseThrow();//optional döndüğü için id verirsem int veriyorsun diyip kızar bu hata ya get() ya da orElseThrow()yazmalıyız.

    }

    @Override
    public Brand add(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(int id, Brand brand) {
        checkIfBrandExists(id);
        brand.setId(id);
        return brandRepository.save(brand);
    }

    @Override
  public void delete(int id) {
        checkIfBrandExists(id);
        brandRepository.deleteById(id);
    }
    private void checkIfBrandExists(int id) {
        if (!brandRepository.existsById(id)) throw new RuntimeException("Böyle bir marka mevcut değil.");
    }
}
