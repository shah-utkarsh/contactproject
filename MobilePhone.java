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
import java.util.ArrayList;
public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>(); 
    }
    
    public void printContact(){
        System.out.println("Contact List:");
        for(int i=0 ;i< myContacts.size() ; i++){
            System.out.println((i+1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
    public boolean addnewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println( " Contact already exists ");
            return false;
        }
        
        myContacts.add(contact);
        
        return true;
    }
    public boolean updateContact(Contact oldContact , Contact newContact){
        int foundposition = findContact(oldContact);
        if(foundposition < 0){
            System.out.println(oldContact.getName()+ " , was not found.");
            return false;
        }
        this.myContacts.set(foundposition,newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName()) ;
        return true;
    }
    private int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }
    private int findContact(String contactname){
        for(int i=0 ; i<myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactname)){
                return i;
            }
        }
        return -1;
    }
    public boolean removeContact(Contact contact){
        int foundposition = findContact(contact);
        if(foundposition>0 )
        {
            System.out.println(contact.getName() + " , was not found.");
            return false;
        }
        
        this.myContacts.remove(foundposition);
        System.out.println(contact.getName() + " is successfully deleted ");
        return true;
    }
    
    
    public String queryContact(Contact contact){
        if(findContact(contact) > 0){
            return contact.getName();
        }
        return null;
    }
    
    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }
}
