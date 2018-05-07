package com.sasan.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

    private static  Scanner scanner=new Scanner(System.in);
    private static ArrayList<Contact> contacts=new ArrayList<Contact>();

    public static void main(String[] args) {
        while(true) {
            int option = menu();
            switch (option) {
                case 1:
                    System.exit(0);
                    break;
                case 2:
                    printLIstOfContacts();
                    break;
                case 3:
                    addNewContact();
                    break;
                case 4:
                    updateExictingContact();
                    break;
                case 5:
                    removeContact();
                    break;
                case 6:
                    find();

            }
        }
    }

    private static void find() {
      System.out.println("Please senter the name that you are looking for:");
      int pos=findContact(scanner.next());
      if(pos>-1)
          System.out.println(contacts.get(pos) +" Is available in the position of"+pos+" your system");
      else
          System.out.println("your name is not available!");
    }

    private static int findContact(String name) {
      for(Contact contact:contacts){
          if(contact.getName().equals(name))
              return contacts.indexOf(contact);
      }
      return -1;
    }

    private static void removeContact() {
        printLIstOfContacts();
        System.out.println("Please select which contact need to be deleted:");
        int pos=findContact(scanner.next());
        if(pos>-1)
            contacts.remove(pos);
        else
            System.out.println("Sorry! This name is not available in the system.");

    }

    private static void updateExictingContact() {
        printLIstOfContacts();
        System.out.println("Please select which contact need to be update and enter the name:");
        String name=scanner.next();
        System.out.println("Please enter new name:");
        String newName=scanner.next();
        System.out.println("Please enter the phone number:");
        int newNum=scanner.nextInt();

        int position=findContact(name);
        if(position>=0){
            contacts.set(position, new Contact(newName,newNum));
        }else
            System.out.println("Please select the contact form the list.");
    }

    private static void addNewContact() {
        System.out.println(" please Enter the name of person: ");
        String name=scanner.next();
        System.out.println(" Please enter the tell number: ");
        int num= scanner.nextInt();
        Contact contact=new Contact(name, num);
        if(!isAvailableContact(contact))
            contacts.add(contact);
        else
            System.out.println("this contact is available in your system!");
    }

    private static boolean isAvailableContact(Contact contact) {
        if(contacts.contains(contact))
            return true;
        else
            return false;


    }

    private static void printLIstOfContacts() {
        for(Contact contact: contacts){
            System.out.println(contact);
        }
    }

    private static int menu(){
        System.out.println("1- Quite");
        System.out.println("2- Print list of contacts");
        System.out.println("3- Add new contact");
        System.out.println("4- Update existing contact");
        System.out.println("5- Remove contact");
        System.out.println("6- Search/Find contact");
        return scanner.nextInt();
    }
}
