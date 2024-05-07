package lydialogic.rentacar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor //ModelMapper Injection - bir kere uretip bu birden fazla kullanacak olan yapi
public class ModelMapperManager implements ModelMapperService {
    private ModelMapper modelMapper;
    @Override
    public ModelMapper forResponse() { //strateji belirledik
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true) //belirsizlik olursa ignore et ben dedigimi kabul et demek icin ekledik.
                .setMatchingStrategy(MatchingStrategies.LOOSE); //gevsek mapleme yap - yani dbye her alani gondemesem de mapleme yapmasi icin loose yazdik
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() { //strateji belirledik
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true) //belirsizlik olursa ignore et ben dedigimi kabul et demek icin ekledik.
                .setMatchingStrategy(MatchingStrategies.STANDARD); //stardart mapleme yap - yani hersey gelen herseyi maplenmesi icin Standart olarak belirledik. birebir db ile uyumlu birsekilde olmasi icin strick yaziyoruz
        return this.modelMapper;
    }
}
