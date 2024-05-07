package lydialogic.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="brands") //lombok sayesinde db ya brands adinda table olusturmus olduk
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "brand") //Brand id den Model id (birden cok) ye olan iliski
    List<Model> models;

    // artik asagidakilerine ihtiyacimiz yok......
//    public Brand() {
//    }
//
//    public Brand(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
