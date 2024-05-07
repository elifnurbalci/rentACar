package lydialogic.rentacar.business.concretes;

import lydialogic.rentacar.business.abstracts.BrandService;
import lydialogic.rentacar.business.requests.CreateBrandRequest;
import lydialogic.rentacar.business.requests.UpdateBrandRequest;
import lydialogic.rentacar.business.responses.GetAllBrandsResponse;
import lydialogic.rentacar.business.responses.GetByIdBrandResponse;
import lydialogic.rentacar.core.utilities.mappers.ModelMapperService;
import lydialogic.rentacar.dataAccess.abstracts.BrandRepository;
import lydialogic.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //bu sinif bir business nesnesidir demek icin yazdik
@AllArgsConstructor //Autowired kismini kaldirdik bunu ekledik. IOC de olusturacak. bir kere uretip bircok yerde kullanmasini saglayacagiz (private BrandRepository) bu yuzden ekledik
public class BrandManager implements BrandService {
    private BrandRepository brandRepository; //manager sadece interface ile haberlesmeli!
    private ModelMapperService modelMapperService;

//    @Autowired
//    public BrandManager(BrandRepository brandRepository) {
//        this.brandRepository = brandRepository;
//    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll(); //for mapping

//        List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();//for mapping

//        for (Brand brand : brands) {//mapping
//            GetAllBrandsResponse brandResponse = new GetAllBrandsResponse();//for mapping
//            brandResponse.setId(brand.getId());//for mapping
//            brandResponse.setName(brand.getName());//for mapping
//            brandsResponse.add(brandResponse);
//        }

        List<GetAllBrandsResponse> brandsResponse = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList()); // yukaridaki gibi foreach ile gezerek tek tek alanlari yazmak zorunda degiliz. bu sekilde kullanmaliyiz!!

        //is kurallari
        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
//        Brand brand = new Brand();
//        brand.setName(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class); //neyi neye map ediyim sorusunun cevabi: createBrandRequest dan brand tipine cevir demis olduk
        // bu bir veri tabani nesnesi olmus oldu yani yeni bir brand olusurup map etmis olduk

        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
