package project;
import java.util.Scanner;
class Meeting_application {
    static String Application_name="HORIZEN CONNECT";
}
class User{
    private String email;
    private String user_id;
    private String password;
    User(String e, String u, String p){
        this.email = e;
        this.user_id = u;
        this.password = p;
    }
    public String getEmail() {
        return email;
    }
    public String getUser_id() {
        return user_id;
    }
    public String getPassword() {
        return password;
    }
    public void setEmail(String Email) {
        this.email = Email;
    }

    public void Setuser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}
class Account extends User{
    private String Entered_userid;
    private String Entered_password;
    Account(String e, String u, String p,String E, String P) {
        super(e,u,p);
        this.Entered_userid = E;
        this.Entered_password = P;
    }

    public String getEntered_userid() {
        return Entered_userid;
    }

    public String getEntered_password() {
        return Entered_password;
    }
    public void setEntered_userid(String Userid) {
        this.Entered_userid = Userid;
    }
    public void setEntered_password(String Password) {
        this.Entered_password = Password;
    }
    void function(MeetingAttendee meetingAttendee,CollabrationCorner discuss) {
        Scanner s = new Scanner(System.in);
        System.out.println("_____________________________________________________________________________");
        System.out.println("\t\t\t\t\t<<Welcome to " + Meeting_application.Application_name + ">>\t\t\t\t\t");
        System.out.println("_____________________________________________________________________________");
        System.out.println("\t\t\t<Do you want to join with guest account or sign in?>\t\t\t");
        System.out.print("Enter 1 for guest account and 2 for sign in:");
        int input = s.nextInt();
        s.nextLine();
        if(input==1)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("_____________________________________________________________________________");
            System.out.println("\t\t\t\t\tWelcome to Guest Account\t\t\t\t\t");
            System.out.println("\t\t<Do you want to join session or join Collabration corner>\t\t");
            System.out.print("Enter 1 for join session and 2 for Collabration corner:");
            int select = sc.nextInt();
            if (select==1) {
                meetingAttendee.joinsession();
            }else {
                discuss.EventCalendar();
            }
        }
        else {
            created();
        }
    }
    void created() {
        Scanner s = new Scanner(System.in);
        System.out.println("_____________________________________________________________________________");
        System.out.println("\t\t\t\t\t\tCreating Account\t\t\t\t\t\t");
        {
            System.out.print("Email:");
            setEmail(s.nextLine());
            System.out.print("Userid:");
            Setuser_id(s.nextLine());
            System.out.print("Password:");
            setpassword(s.nextLine());
            System.out.println("Your account has been suceesfully created");
            System.out.println("_____________________________________________________________________________");
            login();
        }
    }

    void login(){
        Scanner s = new Scanner(System.in);
        int maxAttempts=3;
        int attempts=0;
        while (attempts<maxAttempts) {
            System.out.println("\t\t\t\t\t\tLogin account\t\t\t\t\t\t");
            System.out.print("Userid:");
            setEntered_userid(s.nextLine());
            System.out.print("Password:");
            setEntered_password(s.nextLine());
            if (getEntered_userid().equals(getUser_id()) && getEntered_password().equals(getPassword()))
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Your account has been logged in successfully");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\t<Do you want to join session or join Collabration corner>\t\t");
                System.out.print("Enter 1 for join session and 2 for Collabration corner:");
                MeetingAttendee meetingAttendee=new MeetingAttendee();
                CollabrationCorner discuss=new CollabrationCorner();
                int select = sc.nextInt();
                if (select==1) {
                    meetingAttendee.joinsession();
                }else {
                   discuss.EventCalendar();
                }
                return;
            }
            else{
                attempts++;
                System.out.println("Invalid Userid or password. Remaining attempts: "+(maxAttempts-attempts));
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }

        System.out.println("Maximum login attempts exceeded. Please try again later.");
    }
}
class MeetingAttendee {
    public void joinsession() {
        Scanner sc = new Scanner(System.in);
        System.out.println("_____________________________________________________________________________");
        System.out.println("\t\t\t\t\t------Join session------\t\t\t\t\t");
        boolean sessionJoined = false;
        while (!sessionJoined){
        System.out.println("How do you want to join the meeting?");
        System.out.print("Enter 1 for Meeting Id and 2 for Meeting url:");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            System.out.println("Meeting id is sk8899. Enter this meeting id to join the meeting");
            System.out.print("Enter Meeting ID: ");
            String enteredMeetingId = sc.nextLine();
            if (enteredMeetingId.equals("sk8899")) {
                System.out.println("Joining meeting with ID: " + enteredMeetingId);
                sessionJoined=true;
                settings();
            } else {
                System.out.println("Wrong meeting ID. Please enter the correct meeting ID.");
            }
        } else if (choice==2) {
            System.out.println("URL is http/56.com");
            System.out.print("Enter Meeting URL: ");
            String meetingUrl = sc.nextLine();
            if (meetingUrl.equals("http/56.com")) {
                System.out.println("Joining meeting at URL: "+meetingUrl);
                sessionJoined=true;
                settings();
            } else {
                System.out.println("Wrong URL. Please enter the correct URL.");
            }
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }
    }
    void settings() {
        Scanner sc = new Scanner(System.in);
        System.out.println("_____________________________________________________________________________");
        System.out.print("Do you wanna unmute?y/n:");
        char userssettings = sc.next().charAt(0);
        sc.nextLine();
        switch (userssettings) {
            case 'y': {
                System.out.println("Join meeting with unmuted mic");
            }
            break;
            case 'n': {
                System.out.println("join meeting with muted mic");
            }
            break;
        }
        features();
    }

    void features() {
        System.out.println("_____________________________________________________________________________");
        Scanner sc = new Scanner(System.in);
        System.out.print("Select a feature:\n1.Video Settings\n2.Screen Sharing\n3.Participant List\n4.Raise Hand\n5.Noise Cancelation\nEnter What you want:");
        int choice = sc.nextInt();
        System.out.println("_____________________________________________________________________________");
        switch (choice) {
            case 1: {
                Scanner s = new Scanner(System.in);
                System.out.print("Video:Enter 1 for Enable and 2 for Disable:");
                int video = s.nextInt();
                if (video == 1) {
                    System.out.println("The video has Enabled");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                } else {
                    System.out.println("The video has Disabled");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
            case 2: {
                System.out.print("Screen Sharing:Enter 1 for Enable and 2 for Disable:");
                int screensharing = sc.nextInt();
                if (screensharing == 1) {
                    System.out.println("The Screensharing has Enabled");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                } else {
                    System.out.println("The Screensharing has Disabled");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
            case 3: {
                System.out.print("Participant list:Enter 1 for show and 2 for hide:");
                int participantlist = sc.nextInt();
                if (participantlist == 1) {
                    System.out.println("The Participant list show");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                } else {
                    System.out.println("The Participant list hide");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
            case 4: {
                System.out.print("Raise Hand:Enter 1 for Enable and 2 for Disable:");
                int raisehand = sc.nextInt();
                if (raisehand == 1) {
                    System.out.println("The raisehand has Enabled");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                } else {
                    System.out.println("The raisehand has Disabled");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
            case 5: {
                System.out.print("Noise Cncelation:Enter 1 for Enable and 2 for Disable:");
                int nc = sc.nextInt();
                if (nc == 1) {
                    System.out.println("The Noise cancelation has Enabled");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                } else {
                    System.out.println("The Noise cancelation has Disabled");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
        }
        Scanner s=new Scanner(System.in);
        CollabrationCorner discuss=new CollabrationCorner();
        System.out.println("\t\t\t\tDo you want to open live chat\t\t\t\t");
        System.out.print("Enter 1 for open live chat and Enter 2 for disbale live chat:");
        int choose=s.nextInt();
        if(choose==1){
          discuss.livechat();
        }
        else {
            System.out.println("Live chat has been disabled");
        }
    }
}
    class CollabrationCorner {
        void EventCalendar() {
            Scanner sc = new Scanner(System.in);
            System.out.println("_____________________________________________________________________________");
            System.out.println("\t\t\t\tWelcome to Collaboration Corner\t\t\t\t");
            System.out.print("Enter the Date (1 to 31):");
            int day = sc.nextInt();
            System.out.print("Enter the Month (1 to 12):");
            int month = sc.nextInt();
            System.out.print("Enter the year:");
            int year = sc.nextInt();
            sc.nextLine();

            if (month>=1 && month<=12) {
                int daysInMonth;

                if (month==4 ||month==6 || month==9 || month==11) {
                    daysInMonth=30;
                } else if (month==2) {
                    if ((year%4==0 &&year%100!=0) || (year%400==0)) {
                        daysInMonth=29;
                    } else {
                        daysInMonth=28;
                    }
                } else {
                    daysInMonth=31;
                }

                if (day>=1&&day<=daysInMonth) {
                    System.out.println("Valid date: " + day + " :" + month + " :" + year);
                    String userdate = String.format("%d-%d-%d", day, month, year);
                    String[] bookedDates = {"1-5-2024", "5-5-2024", "10-5-2024", "15-5-2024", "20-5-2024", "25-5-2024", "30-5-2024"};
                    boolean booked = false;
                    for (String bookedDate : bookedDates) {
                        if (userdate.equals(bookedDate)) {
                            booked = true;
                            break;
                        }
                    }
                    if (booked) {
                        System.out.println("This date already has an Event");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    } else {
                        System.out.println("This date doesn't have any Event");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    }
                } else {
                    System.out.println("Incorrect day for the selected month.");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
            Scanner s=new Scanner(System.in);
            CollabrationCorner discuss=new CollabrationCorner();
            System.out.println("\t\t\t\tDo you want to open live chat\t\t\t\t");
            System.out.print("Enter 1 for open live chat and Enter 2 for disbale live chat:");
            int choose=s.nextInt();
            if(choose==1){
                discuss.livechat();
            }
            else {
                System.out.println("Live chat has been disabled");
            }
        }
        void livechat(){
                Scanner sc=new Scanner(System.in);
                String choose[] = {"Send Message", "React to message", "Exit"};
                for (int i = 0; i < choose.length; i++) {
                    System.out.println((i + 1) + ". " + choose[i]);
                }
                System.out.print("Select an option: ");
                int select = sc.nextInt();
                sc.nextLine();
                switch (select) {
                    case 1: {
                        System.out.print("Enter your message: ");
                        String message = sc.nextLine();
                        System.out.println("Message sent: " + message);
                        System.out.println("~~~~~~~~~~~~~~~~~~~THANKYOU FOR USING HORIZONTEL CONNECT~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        break;
                    }
                    case 2: {
                        String[] reactions = {"Like", "Heart", "Laugh"};
                        System.out.print("Enter the message ID you want to react to:");
                        String messageId = sc.nextLine();
                        for (int rec = 0; rec < reactions.length; rec++) {
                            System.out.println((rec + 1) + ". " + reactions[rec]);
                        }

                        System.out.print("Select reaction (1-" + reactions.length + "):");
                        int reactionChoice = sc.nextInt();
                        if (reactionChoice >= 1 && reactionChoice <= reactions.length) {
                            String reaction = reactions[reactionChoice - 1];
                            System.out.println("Reaction: " + reaction + " added to message " + messageId);
                            System.out.println("~~~~~~~~~~~~~~~~~~~THANKYOU FOR USING HORIZONTEL CONNECT~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        } else {
                            System.out.println("Invalid reaction choice.");
                            System.out.println("~~~~~~~~~~~~~~~~~~~THANKYOU FOR USING HORIZONTEL CONNECT~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Exiting Live Chat.");
                        System.out.println("~~~~~~~~~~~~~~~~~~~THANKYOU FOR USING HORIZONTEL CONNECT~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        break;
                    }
                    default: {
                        System.out.println("Invalid choice. Exiting Live Chat.");
                        System.out.println("~~~~~~~~~~~~~~~~~~~THANKYOU FOR USING HORIZONTEL CONNECT~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        break;
                }
            }
        }
        public static void main(String[] args) {
            Account acc = new Account("soojal@gmail.com", "bajaj", "sk123", "soojal@gamil.com", "sk123");
            MeetingAttendee meetingAttendee = new MeetingAttendee();
            CollabrationCorner discuss=new CollabrationCorner();
            acc.function(meetingAttendee,discuss);
        }
    }