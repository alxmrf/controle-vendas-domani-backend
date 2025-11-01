package knt.org.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultorInputDto {

    @NonNull
    String username;
    @NonNull
    String cargo;
    @NonNull
    String area;
    @NonNull
    String nome;



}
