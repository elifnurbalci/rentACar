package lydialogic.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="models") //lombok sayesinde db ya models adinda table olusturmus olduk
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @ManyToOne // model id (birden cok) den brand id ye gidis
    @JoinColumn(name="brand_id") // db ye yeni bir col ekleyerek model ile brand arasinda iliski kuracak - model class i icinde oldugumuz icin brand_id ile eslestirdik
    private Brand brand;

}
