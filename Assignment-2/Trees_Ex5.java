// Iman Ereiqat
// Uber Career Prep Homework Trees Ex5
// June 9, 2021
//
 
import java.util.*;

interface PhoneBook 
{
    /**
     * @return The number of entries in this phone book.
     */
    public int size();  
    /**
     * Inserts an entry in this phone book.
     * @param name The name for the entry.
     * @param phoneNumber The phone number for the entry.
     */
    public void insert(String name, long phoneNumber);  
    /**
     * Returns the phone number associated with a name in the phone book.
     * @param name The name to search for.
     * @return The phone number for the entry, or -1 if the name is not present in the phone book.
     */
    public long find(String name);
}

class ListPhoneBook implements PhoneBook
{
    List<String> names = new ArrayList<>();
    List<Long> numbers = new ArrayList<>();
    
    @Override
    public int size()
    {
        if (names.size() > 0)
        {
            return names.size();
        }
        return 0;
    }
    
    @Override
    public void insert(String name, long phoneNumber)
    {
        names.add(name);
        numbers.add(phoneNumber);
    }
    
    @Override
    public long find(String name)
    {
        if (names.size() > 0)
        {
            for (int i = 0; i < names.size(); i++)
            {
                if (name.equals(names.get(i)))
                {
                    return numbers.get(i);
                }
            }
        }
        return -1;
    }
}

class Entry
{
    String name;
    long phoneNumber;
    Entry left;
    Entry right;
    
    public Entry(String name, long phoneNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
    
class BinarySearchTreePhoneBook implements PhoneBook
{
    Entry root;
    public BinarySearchTreePhoneBook(Entry root)
    {
        this.root = root;
    }
    
    @Override
    public int size()
    {
        return 0;
    }
    
    @Override
    public void insert(String name, long phoneNumber)
    {
        if (root == null)
        {
            root = new Entry(name, phoneNumber);
        }
        
        Entry temp = root;
        while(temp != null)
        {
            if (name.compareTo(temp.name) < 0)
            {
                if (temp.left != null)
                {
                    temp = temp.left;
                }
                else
                {
                    temp.left = new Entry(name, phoneNumber);
                    break;
                }
            }
            else if (name.compareTo(temp.name) > 0)
            {
                if (temp.right != null)
                {
                    temp = temp.right;
                }
                else
                {
                    temp.right = new Entry(name, phoneNumber);
                    break;
                }
            }
        }
    }
    
    @Override
    public long find(String name)
    {
        if (root == null)
        {
            return -1;
        }
        
        Entry temp = root;
        while (temp != null)
        {
            if (name.compareTo(temp.name) < 0)
            {
                temp = temp.left;
            }
            else if (name.compareTo(temp.name) > 0)
            {
                temp = temp.right;
            }
            else
            {
                return temp.phoneNumber;
            }
        }
        return -1;
    }
}

public class Trees_Ex5
{
    public static void main(String args[])
    {
        System.out.println("\n***UCP HW TREES EX5***\n");
        
        ListPhoneBook listPhoneBook = new ListPhoneBook();
        
        listPhoneBook.insert("ABC", 1111111111L);
        listPhoneBook.insert("XYZ", 9999999999L);
        listPhoneBook.insert("DEF", 2222222222L);
        listPhoneBook.insert("Uber", 1234567890L);
        listPhoneBook.insert("Career", 9899899779L);
        listPhoneBook.insert("Prep", 70712345678L);
        listPhoneBook.insert("Iman", 6789998212L);
        listPhoneBook.insert("Ereiqat", 18005683L);

        System.out.printf("listPhoneBook.find('ABC'): %d\n", listPhoneBook.find("ABC"));
        System.out.printf("listPhoneBook.find('XYZ'): %d\n", listPhoneBook.find("XYZ"));
        System.out.printf("listPhoneBook.find('PQR'): %d\n", listPhoneBook.find("PQR"));
        System.out.printf("listPhoneBook.find('Iman'): %d\n", listPhoneBook.find("Iman"));
        System.out.printf("listPhoneBook.find('Ereiqat'): %d\n", listPhoneBook.find("Ereiqat"));
        System.out.printf("listPhoneBook.find('Uber'): %d\n\n", listPhoneBook.find("Uber"));
        
        Entry root = new Entry("ABC", 1111111111L);
        BinarySearchTreePhoneBook BSTPhoneBook = new BinarySearchTreePhoneBook(root);
        BSTPhoneBook.insert("XYZ", 9999999999L);
        BSTPhoneBook.insert("Uber", 1234567890L);
        BSTPhoneBook.insert("Career", 9899899779L);
        BSTPhoneBook.insert("Prep", 70712345678L);
        BSTPhoneBook.insert("Iman", 6789998212L);
        BSTPhoneBook.insert("Ereiqat", 18005683L);

        System.out.printf("BinarySearchTreePhoneBook.find('ABC'): %d\n", BSTPhoneBook.find("ABC"));
        System.out.printf("BinarySearchTreePhoneBook.find('XYZ'): %d\n", BSTPhoneBook.find("XYZ"));
        System.out.printf("BinarySearchTreePhoneBook.find('PQR'): %d\n", BSTPhoneBook.find("PQR"));
        System.out.printf("BinarySearchTreePhoneBook.find('Iman'): %d\n", BSTPhoneBook.find("Iman"));
        System.out.printf("BinarySearchTreePhoneBook.find('Ereiqat'): %d\n", BSTPhoneBook.find("Ereiqat"));
        System.out.printf("BinarySearchTreePhoneBook.find('Uber'): %d\n", BSTPhoneBook.find("Uber"));
    }   
}