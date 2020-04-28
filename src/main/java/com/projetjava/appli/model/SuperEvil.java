package com.projetjava.appli.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table( name = "superevil")
public class SuperEvil extends Civil{


}
