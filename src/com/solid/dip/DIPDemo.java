/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Utkarsh Pratap Singh
 */
package com.solid.dip;

import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// A. High-level modules should not depend on low-level modules. 
// Both should depend on abstractions.
// B. Abstractions should not depend on details. 
// Details should depend on abstractions.
enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

class Person {

    public String name;
    // dob etc.

    public Person(String name) {
        this.name = name;
    }
}

interface RelationshipBrowser {

    List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser {

    @Override
    public List<Person> findAllChildrenOf(String name) {

        return relations.stream()
                .filter(x -> Objects.equals(x.getValue0().name, name)
                && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }

    // Triplet class requires javatuples
    private List<Triplet<Person, Relationship, Person>> relations
            = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }
}

class Research {

    public Research(Relationships relationships) {
        // high-level: find all of parent's children
        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
        relations.stream()
                .filter(x -> x.getValue0().name.equals("Utkarsh")
                && x.getValue1() == Relationship.PARENT)
                .forEach(ch -> System.out.println("Utkarsh has a child called " + ch.getValue2().name));
    }

    public Research(RelationshipBrowser browser) {
        List<Person> children = browser.findAllChildrenOf("Utkarsh");
        for (Person child : children) {
            System.out.println("Utkarsh has a child called " + child.name);
        }
    }
}

public class DIPDemo {

    public static void main(String[] args) {
        Person parent = new Person("Utkarsh");
        Person child1 = new Person("Baba");
        Person child2 = new Person("Uttu");

        // low-level module
        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}
