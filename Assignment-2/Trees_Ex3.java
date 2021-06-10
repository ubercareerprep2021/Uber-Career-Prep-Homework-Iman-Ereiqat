// Iman Ereiqat
// Uber Career Prep Homework Trees Ex3
// May 26, 2021
//

import java.util.*;


public class Trees_Ex3
{
    // Employee class
    static class Employee
    {
        String name;
        String title;
        List<Employee> directReports;
        
        public Employee(String name, String title) 
        {
            this.name = name;
            this.title = title;
            directReports = new ArrayList<>();
        }
    }
    
    // Organization structure class
    static class OrganizationStructure
    {
        Employee ceo;
        
        public OrganizationStructure(Employee ceo) 
        {
            this.ceo = ceo;
        }
        
        // Function printLevelByLevel prints each level
        // of the tree using a queue
        public void printLevelByLevel(Employee ceo) 
        {
            Queue<Employee> eQueue = new LinkedList<>();
            eQueue.add(ceo);
            int size = 0;
            
            while (eQueue.size() > 0)
            {
                size = eQueue.size();
                
                for (int i = 0; i < size; i++)
                {
                    Employee curr = eQueue.poll(); 
                    System.out.printf("Name: %s, Title: %s\n", curr.name, curr.title);

                    if (!curr.directReports.isEmpty()) 
                    {
                        for (int j = 0; j < curr.directReports.size(); j++)
                        {
                            eQueue.add(curr.directReports.get(j)); 
                        }
                    }
                }
                System.out.println("");
            }
        }
        
        // Function prints the number of levels
        // in the organization structure
        public void printNumLevels(Employee ceo)
        {
            Queue<Employee> eQueue = new LinkedList<>();
            eQueue.add(ceo);
            int size = 0;
            int count = 0;
            
            while (eQueue.size() > 0)
            {
                size = eQueue.size();
                
                for (int i = 0; i < size; i++)
                {
                    Employee curr = eQueue.poll(); 
                    if (!curr.directReports.isEmpty()) 
                    {
                        for (int j = 0; j < curr.directReports.size(); j++)
                        {
                            eQueue.add(curr.directReports.get(j)); 
                        }
                    }
                }
                count++;
            }
            System.out.printf("Number of levels: %d\n\n", count);
        }
    }
    
    public static void main(String args[])
    {
        System.out.println("\n***UCP HW TREES EX3***\n");
        
        Employee ceo = new Employee("A", "CEO");
        
        Employee cfo = new Employee("B", "CFO");
        Employee cto = new Employee("C", "CTO");
        
        ceo.directReports.add(cfo);
        ceo.directReports.add(cto);
        
        Employee director = new Employee("I", "Director");
        Employee manager1 = new Employee("D", "Manager");
        Employee manager2 = new Employee("E", "Manager");
        
        cfo.directReports.add(director);
        
        cto.directReports.add(manager1);
        cto.directReports.add(manager2);
        
        Employee salesRep = new Employee("J", "Sales Representative");
        Employee eng1 = new Employee("F", "Engineer");
        Employee eng2 = new Employee("G", "Engineer");
        Employee eng3 = new Employee("H", "Engineer");

        director.directReports.add(salesRep);
        manager1.directReports.add(eng1);
        manager1.directReports.add(eng2);
        manager1.directReports.add(eng3);
        
        Employee intern = new Employee("K", "Sales Intern");
        
        salesRep.directReports.add(intern);
        
        OrganizationStructure organizationStruct = new OrganizationStructure(ceo);
        
        organizationStruct.printNumLevels(ceo);
        
        organizationStruct.printLevelByLevel(ceo);
    }
}