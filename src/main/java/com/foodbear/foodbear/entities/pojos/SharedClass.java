package com.foodbear.foodbear.entities.pojos;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.text.ParseException;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public abstract class SharedClass {


    @Id
    @GeneratedValue
    Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdDate = LocalDateTime.now();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updatedDate;

    //userId??
    @JsonIgnore
    @CreatedBy
    Integer createdBy;

    //userId??
    @JsonIgnore
    @LastModifiedBy
    Integer updateBy;

    /*
    public void setCreatedDate() throws ParseException {
        this.createdDate = LocalDateTime.now();
    }
     */

    public void setUpdatedDate() throws ParseException {
        this.updatedDate = LocalDateTime.now();
    }


}
