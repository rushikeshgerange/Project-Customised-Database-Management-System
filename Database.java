// Customised Database Management System

class node
{
    private static int Counter = 1;
    public int Rno;
    public String Name;
    public String City;
    public int Marks;
    public node next;

    public node(String B, String C, int D)
    {
        Rno = Counter;
        Counter++;
        Name = B;
        City = C;
        Marks = D;
        next = null;
    }
}

class DBMS
{
    public node first;
    int iCnt;

    public DBMS()
    {
        first = null;
        iCnt = 0;

        System.out.println("-----------------------------------------------");
        System.out.println("Customised Database Management System");
        System.out.println("-----------------------------------------------");
        System.out.println("DBMS initialize successfully...");
        System.out.println("Student table gets created successfully...");
    }

    // InsertLast()
    // insert into student table(1, "Amit", "Pune", 89)
    public void InsertIntoTable(String Name, String City, int Marks)
    {
        node newn = new node(Name, City, Marks);

        if(first == null)
        {
            first = newn;
        }
        else
        {
            node temp = first;

            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newn;
        }
    }

    // Display()
    // select * from student();
    public void SelectStarFrom()
    {
        node temp = first;

        System.out.println();
        System.out.println("-------------STUDENT TABLE-------------");
        System.out.println("---------------------------------------");
        System.out.println("| Rno | Name   | City   | Marks |");
        System.out.println("---------------------------------------");

        while(temp != null)
        {
            System.out.println("  "+temp.Rno+"\t"+temp.Name+"\t "+temp.City+"\t  "+temp.Marks+"\t");
            temp = temp.next;
        }
        System.out.println("---------------------------------------");
        System.out.println();
    }

    // select * from student where city = "_______";
    public void SelectStarFromWhereCity(String str)
    {
        node temp = first;

        System.out.println();

        System.out.println("Data from student table where city is : "+str);

        System.out.println("---------------------------------------");

        while(temp != null)
        {
            if(str.equals(temp.City))
            {
                System.out.println("  "+temp.Rno+"\t"+temp.Name+"\t "+temp.City+"\t  "+temp.Marks+"\t");
            }
            temp = temp.next;
        }
        System.out.println("---------------------------------------");
        System.out.println();
    }

    public void SelectCount()   // Aggrigate Function
    {
        node temp = first;
        int iCnt = 0;

        while(temp != null)
        {
            temp = temp.next;
            iCnt++;
        }
        System.out.println("Number of records in the table : "+iCnt);
    }

    public void SelectSum()   // Aggrigate Function
    {
        node temp = first;
        int iSum = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp = temp.next;
        }
        System.out.println("Summation of marks column is : "+iSum);
    }

    public void SelectAvg()   // Aggrigate Function
    {
        node temp = first;
        int iSum = 0;
        int iCnt = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp = temp.next;
            iCnt++;
        }
        System.out.println("Average of marks column is : "+((float)iSum / (float)iCnt));
    }

    public void SelectMax()   // Aggrigate Function
    {
        node temp = first;
        int iMax = 0;

        if(temp != null)
        {
            iMax = temp.Marks;
        }

        while(temp != null)
        {
            if(temp.Marks > iMax)
            {
                iMax = temp.Marks;
            }
            temp = temp.next;
        }
        System.out.println("Maximum of marks column is : "+iMax);
    }

    public void SelectMin()   // Aggrigate Function
    {
        node temp = first;
        int iMin = 0;

        if(temp != null)
        {
            iMin = temp.Marks;
        }
        

        while(temp != null)
        {
            if(temp.Marks < iMin)
            {
                iMin = temp.Marks;
            }
            temp = temp.next;
        }
        System.out.println("Minimum of marks column is : "+iMin);
    }

    // select * from student where name = "_______";
    public void SelectStarFromWhereName(String str)
    {
        node temp = first;

        System.out.println();

        System.out.println("Data from student table where name is : "+str);

        System.out.println("---------------------------------------");

        while(temp != null)
        {
            if(str.equals(temp.Name))
            {
                System.out.println("  "+temp.Rno+"\t"+temp.Name+"\t "+temp.City+"\t  "+temp.Marks+"\t");
            }
            temp = temp.next;
        }
        System.out.println("---------------------------------------");
        System.out.println();
    }

    public void UpdateCity(int no, String str)
    {
        node temp = first;

        while(temp != null)
        {
            if(temp.Rno == no)
            {
                temp.City = str;
                break;
            }
            temp = temp.next;
        }
        System.out.println("Record gets successfully updated...");
        System.out.println();
    }

    public void DeleteFrom(int no)
    {
        node temp = first;

        if(temp == null)
        {
            return;
        }

        // if first node is the targeted node
        if(temp.Rno == no)
        {
            first = first.next;
            return;
        }

        while(temp.next != null)
        {
            if(temp.next.Rno == no)
            {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

class Database
{
    public static void main(String args[])
    {
        DBMS obj = new DBMS();

        obj.InsertIntoTable("Amit", "Pune",89);
        obj.InsertIntoTable("Pooja", "Mumbai",95);
        obj.InsertIntoTable("Gauri", "Pune",90);
        obj.InsertIntoTable("Amit", "Nagar",81);
        obj.InsertIntoTable("Rahul", "Satara",80);
        obj.InsertIntoTable("Neha", "Pune",78);

        obj.SelectStarFrom();
        obj.SelectCount();
        obj.SelectSum();
        obj.SelectAvg();
        obj.SelectMax();
        obj.SelectMin();

        obj.SelectStarFromWhereCity("Pune");
        obj.SelectStarFromWhereName("Amit");

        obj.UpdateCity(3,"Nashik");
        obj.SelectStarFrom();

        obj.DeleteFrom(5);
        obj.SelectStarFrom();

        obj.InsertIntoTable("Ruchita", "Sangli", 77);
        obj.InsertIntoTable("Swayam","Satara",79);
        obj.SelectStarFrom();
        obj.SelectCount();

    }
}




/*
 Supported Queries
 
 1  : insert into student values('Amit','Pune',89);
 2  : insert * from student;
 3  : select * from student where city = '_____';
 4  : select Count(Marks) from student;
 5  : select sum(Marks) from student;
 6  : select avg(Marks) from student;
 7  : select min(Marks) from student;
 8  : select max(Marks) from student;
 9  : select * from student where name = "____";
 10 : update student set City = "_____" where Rno = ___;
11 : delete from student where Rno = ___;
 */