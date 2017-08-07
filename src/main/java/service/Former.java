package service;

import entity.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Former {
    public static Person formPerson(List<Person> persons){
        Person out = null;
        String nPlusSN;
        while(true) {
            Name[] names = Name.values();
            Name name = names[new Random().nextInt(10)];
            String n = name.name();
            Surname[] sNames = Surname.values();
            Surname sName = sNames[new Random().nextInt(10)];
            String sN = sName.name();
            nPlusSN = new StringBuffer(20).append(n).append(" ").append(sN).toString();
            int countSNames = 0;
            for (Person p : persons) {
                if (p.getName().substring((p.getName().indexOf(' ')+1)).equals(sN)) {
                    countSNames++;
                    if(countSNames>1) {
                        continue;
                    }
                }
            }
            break;
        }
        out = new Person(nPlusSN, City.values()[new Random().nextInt(2)].name(), new Random().nextInt(10001)+5000, Position.values()[new Random().nextInt(2)].name());
        return out;
    }
}
