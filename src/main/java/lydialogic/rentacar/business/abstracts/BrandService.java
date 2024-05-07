package lydialogic.rentacar.business.abstracts;

import lydialogic.rentacar.business.requests.CreateBrandRequest;
import lydialogic.rentacar.business.requests.UpdateBrandRequest;
import lydialogic.rentacar.business.responses.GetAllBrandsResponse;
import lydialogic.rentacar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService { //is kurallarini buraya yazicaz
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
