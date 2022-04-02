package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task
{
    @Id
    @GeneratedValue
    private long Id;
    @ManyToOne
    private Subject subject;
    private int taskNr;
}
