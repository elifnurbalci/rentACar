package lydialogic.rentacar.wepApi.controllers;

import lydialogic.rentacar.business.abstracts.BrandService;
import lydialogic.rentacar.business.requests.CreateBrandRequest;
import lydialogic.rentacar.business.requests.UpdateBrandRequest;
import lydialogic.rentacar.business.responses.GetAllBrandsResponse;
import lydialogic.rentacar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands") // http://localhost:8080/api/brands
@AllArgsConstructor //Autowired bolumunu bunu ekledigimiz icin kullanmamiza gerek kalmadi. yerine bunu kullandik. singleton yapisi ile ilgili, bu konuya bakmalisin!!
public class BrandsController {
    private BrandService brandService;

//    @Autowired // sprint boot da IoC denilen bir yapi var. contructor in parametrelerine bak ve kim bu parametreyi implemente ediyor kontrol eder ve onun new lenmis halini bize verir
//    public BrandsController(BrandService brandService) {
//        this.brandService = brandService;
//    }


    //@GetMapping("/getall")  http://localhost:8080/api/brands/getall
    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return this.brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return this.brandService.getById(id);
    }
    //@PostMapping("/add")
    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }
}
