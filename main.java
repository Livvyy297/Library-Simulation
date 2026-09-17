import java.util.Scanner;
import java.util.ArrayList;
class Library
{
    public static void main()
    {
        String ans="";
       ArrayList<Book> book=new ArrayList<>();
       book.add(new Book(001,"HARRY POTTER AND THE CHAMBER OF SECRETS","JK ROWLING"));
       book.add(new Book(002,"PRIDE AND PREJUDICE","JANE AUSTEN"));
       book.add(new Book(003,"TO KILL A MOCKINGBIRD","HARPER LEE"));
       book.add(new Book(004,"THE GREAT GATSBY","F SCOTT FITZGERALD"));
       book.add(new Book(005,"MOBY DICK","HERMAN MELVILLE"));
       book.add(new Book(006,"WAR AND PEACE","LEO TOLSTOY"));
       book.add(new Book(007,"CRIME AND PUNISHMENT","FYODOR DOSTOEVSKY"));
       book.add(new Book(010,"WUTHERING HEIGHTS","EMILY BRONTE"));
       book.add(new Book(011,"THE CATCHER IN THE RYE","JD SALINGER"));
       book.add(new Book(012,"BRAVE NEW WORLD","ALDOUS HUXLEY"));
       book.add(new Book(013,"THE BROTHERS KARAMAZOV","FYODOR DOSTOEVSKY"));
       book.add(new Book(014,"ANIMAL FARM","GEORGE ORWELL"));
       book.add(new Book(015,"THE PICTURE OF DORIAN GRAY","OSCAR WILDE"));
       ArrayList<Book> borrowed=new ArrayList<>();
       int n=0;
       Scanner in= new Scanner(System.in);
       System.out.println("Kindly select the no from the following options");
       System.out.println("1]Add book");
       System.out.println("2]Issue book");
       System.out.println("3]Return book");
       System.out.println("4]Show books available");
       System.out.println("5]Check cart");
       n=in.nextInt();
       in.nextLine();
        while(n!=6)
       {
            switch(n)
            {
              case 1:
                   ans="yes";
                  while(ans.equalsIgnoreCase("Yes"))
                  {System.out.println("BookId:");
                  int id=in.nextInt();
                  in.nextLine();
                                    
                  System.out.println("Title:");
                  String t=in.nextLine();
                  
                  System.out.println("Author:");
                  String au=in.nextLine();
                  
                  au=au.toUpperCase();
                  t=t.toUpperCase();
                  book.add(new Book(id,t,au));
                  System.out.println("Book sucessfully added to the system");
                  System.out.println();
                  System.out.println("Continue?");
                  ans=in.nextLine();
                }
                  break;
                  
              case 2:
                  ans="yes";
                  while(ans.equalsIgnoreCase("Yes"))
                  {System.out.println("Enter book name");
                  String un=in.nextLine();
                  un=un.toUpperCase();
                  int c=0;
                  
                  int l=borrowed.size();
                  if(l>2)
                    {
                        System.out.println("Can't issue more than 3 books!");
                        break;
                    }
                  
                  for(Book obj:book)
                  {
                      if(obj.n.equals(un))
                      {
                          c=1;
                          if(obj.issued)
                          System.out.println("Status:Issued");
                          else
                          {
                              System.out.println("Status:Available");
                              obj.issued=true;
                              System.out.println("Item added to your cart");
                              borrowed.add(obj);
                              break;
                          }
                      }
                  }
                  if(c==0)
                    System.out.println("Book not found in the system");
                  System.out.println();
                  System.out.println("Continue?");
                  ans=in.nextLine();
                }
                  break;
              case 3:
                  ans="yes";
                  while(ans.equalsIgnoreCase("Yes"))
                  {
                  System.out.println("Title of the book:");
                  //in.nextLine();
                  String name=in.nextLine();Book b=null;
                  for(Book obj:borrowed)
                  {
                      if(obj.n.equalsIgnoreCase(name))
                      {
                          b=obj;
                          break;
                      }
                  }
                  if(b!=null)
                  {
                      b.issued=false;
                      borrowed.remove(b);
                      System.out.println("Item removed sucessfully");
                  }
                  else
                   System.out.println("Book not found");
                   System.out.println("Any more books to return?");
                  ans=in.nextLine();
                }
                  break;
              case 4:
                  for(Book obj:book)
                  {
                      if(obj.issued==false)
                       System.out.println(obj.n);
                  }
                  break;
                
              case 5:
                  if(borrowed.size()==0)
                   System.out.println("Cart is empty");
                  else
                  {
                      System.out.println("User's cart:");
                      for(Book obj:borrowed)
                      {
                          System.out.println(obj.n);
                      }
                  }
                  break;
              default:
                  System.out.println("KINDLY ENTER A NO 1-3!");
                  break;
            }
            System.out.println();
            System.out.println("Would you like to exit the website?");
            ans=in.nextLine();
            ans=ans.toUpperCase();
            if(ans.equals("NO"))
             {
                // in.nextLine();
                 System.out.println();
                System.out.println("Kindly select the no from the following options");
                System.out.println("1]Add book");
                System.out.println("2]Issue book");
                System.out.println("3]Return book");
                System.out.println("4]Show books available");
                System.out.println("5]Check cart");
                n=in.nextInt();
                in.nextLine();
             }
            else
            break;
       }
    }
}
class Book
{
    int bid;
    String n, a;
    boolean issued;
    Book(int bid, String n, String a)
    {
        this.bid=bid;
        this.n=n;
        this.a=a;
        issued=false;
    }
}
