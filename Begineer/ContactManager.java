import java.util.*;

class ContactEntry {
    String contactName;
    String phoneNumber;
    String emailAddress;

    public ContactEntry(String contactName, String phoneNumber, String emailAddress) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + contactName + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}

public class ContactManager {
    static ArrayList<ContactEntry> contactList = new ArrayList<>();
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n### Contact Organizer ###");
            System.out.println("1. Add New Contact");
            System.out.println("2. Show All Contacts");
            System.out.println("3. Modify Contact");
            System.out.println("4. Remove Contact");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int option = inputScanner.nextInt();
            inputScanner.nextLine();  

            switch (option) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    displayContacts();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    System.out.println("Exiting Contact Organizer.");
                    return;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }
    }

    public static void addNewContact() {
        System.out.print("Enter full name: ");
        String fullName = inputScanner.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = inputScanner.nextLine();
        System.out.print("Enter email address: ");
        String emailID = inputScanner.nextLine();

        contactList.add(new ContactEntry(fullName, mobileNumber, emailID));
        System.out.println("Contact successfully added!");
    }

    public static void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println((i + 1) + ". " + contactList.get(i));
            }
        }
    }

    public static void modifyContact() {
        System.out.print("Enter the contact number to modify: ");
        int index = inputScanner.nextInt() - 1;
        inputScanner.nextLine();  
        if (index >= 0 && index < contactList.size()) {
            ContactEntry contact = contactList.get(index);
            System.out.print("Enter updated name (press Enter to keep unchanged): ");
            String newName = inputScanner.nextLine();
            System.out.print("Enter updated phone (press Enter to keep unchanged): ");
            String newPhone = inputScanner.nextLine();
            System.out.print("Enter updated email (press Enter to keep unchanged): ");
            String newEmail = inputScanner.nextLine();

            if (!newName.isEmpty()) contact.setContactName(newName);
            if (!newPhone.isEmpty()) contact.setPhoneNumber(newPhone);
            if (!newEmail.isEmpty()) contact.setEmailAddress(newEmail);

            System.out.println("Contact successfully updated!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    public static void removeContact() {
        System.out.print("Enter the contact number to delete: ");
        int index = inputScanner.nextInt() - 1;
        inputScanner.nextLine();  

        if (index >= 0 && index < contactList.size()) {
            contactList.remove(index);
            System.out.println("Contact successfully deleted!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }
}