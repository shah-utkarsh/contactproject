/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utkarsh.arraylistchallengecontact;

/**
 *
 * @author Utkarsh
 */
import java.util.Scanner;
public class Main {

    /**
     * @param args the command line arguments
     */
    private static Scanner sc = new Scanner(System.in);
    private static MobilePhone mobilephone = new MobilePhone("94282 02881");
    public static void main(String[] args) {
        // TODO code application logic here
        boolean quit =false;
        int action = 0;
        printactions();
        while(!quit){
            System.out.println("Enter your action: ");
            action = sc.nextInt();
            sc.nextLine();
            switch(action){
                case 0:
                    System.out.println("\nShutting Down...");
                    quit = true;
                    break;
                case 1:
                    mobilephone.printContact();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    quit = true;
                    break;

            }
        }
    }
    
    private static void addNewContact(){
        System.out.println("Enter new Contact name: ");
        String name = sc.nextLine();
        System.out.println("Enter new Contact number : ");
        String number = sc.nextLine();
        Contact contact = Contact.createContact(name,number);
        if(mobilephone.addnewContact(contact)){
            System.out.println("New Contact name added " + " Name = " + name + " Phone number = " + number);
        }
        else{
        System.out.println("Cannot add " + contact.getName()) ;
        }
    }
    private static void update(){
        System.out.println("Enter name of an existing Contact:");
        String name = sc.nextLine();
        Contact existingOntactrecord = mobilephone.queryContact(name);
        if(existingOntactrecord == null){
            System.out.println("Contact not found.");
            return;
        }
        
        System.out.println("Enter new Name:");
        String newName = sc.nextLine();
        System.out.println("Enter new phone number: ");
        String newnumber = sc.nextLine();
        Contact newCOntact = Contact.createContact(newName, newnumber);
        if(mobilephone.updateContact(existingOntactrecord, newCOntact)){
            System.out.println("Successfully updated record");
        }
        else{
            System.out.println("error updating record");
        }
    }
    private static void printactions(){
            System.out.println("\nAvailble Actions");
            System.out.println("\n 0 - to shutdown" +
                               "\n 1 - to print contact" + 
                               "\n 2 - to add new contact " +
                               "\n 3 - to update an existing contact" +
                               "\n 4 - to remove contact" +
                    "\n 5 - to query if an contacts exist " +
                    "\n 6 - to print available action");
        }
    private static void remove(){
        System.out.println("Enter name of an existing Contact:");
        String name = sc.nextLine();
        Contact existingOntactrecord = mobilephone.queryContact(name);
        if(existingOntactrecord == null){
            System.out.println("Contact not found.");
            return;
        }
        
        if(mobilephone.removeContact(existingOntactrecord)){
            System.out.println("Successfully removed");
        }else{
            System.out.println("error removing.");
        }
    }
    private static void queryContact(){
        System.out.println("Enter name of an existing Contact:");
        String name = sc.nextLine();
        Contact existingOntactrecord = mobilephone.queryContact(name);
        if(existingOntactrecord == null){
            System.out.println("Contact not found.");
            return;
        }
        
        System.out.println("Name = " + existingOntactrecord.getName() + " Number  = " + existingOntactrecord.getPhoneNumber());
}
}