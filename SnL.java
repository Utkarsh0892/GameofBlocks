import java.util.*;
public class SnL
{
    public static int n;
    public int pos[];
    public SnL(int np)
    {
        n=np;
        pos=new int[n];
        for(int i=0;i<n;i++)
        pos[i]=0;
    }
    public int check_snake(int p)
    {
        int f=0,i;
        int Sn1[]={13,52,59,88,92,95,99};
        int Sn2[]={5,26,40,66,70,44,25};
        for(i=0;i<7;i++)
        {
            if(Sn1[i]==pos[p])
            {
                f=1;
                break;
            }
        }
        if(f==1)
        pos[p]=Sn2[i];
        return f;
    }
    public int check_lad(int p)
    { 
        int f=0,i;
        int ld1[]={4,18,22,30,36,58,75};
        int ld2[]={26,39,84,73,54,81,94};
        for(i=0;i<7;i++)
        {
            if(ld1[i]==pos[p])
            {
                f=1;
                break;
            }
        }
        if(f==1)
        pos[p]=ld2[i];
        return f;
    }
    public static void main(String args[])
    {
        int ch=1;
        while(ch!=0)
        {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of players");
        int np=sc.nextInt();
        SnL ob=new SnL(np);
        System.out.println("Enter 1 if you want to give names to players else enter any other number");
        int c=sc.nextInt();
        String s[]=new String[n];
        if(c==1)
        {
            System.out.println("Enter Names");
            for(int i=0;i<n;i++)
            s[i]=sc.next();
        }
        int pmax=0,i=0;
        while(pmax<100)
        {
            for(i=0;i<n;i++)
            {
                int d=0;
                if(c==1)
                System.out.println(s[i]+" enter any character to roll the die.\n enter E to stop the game.");
                else
                System.out.println("Player "+(i+1)+" enter any character to roll the die.\n enter E to stop the game.");
                char x=sc.next().charAt(0);
                if(x=='E')
                System.exit(0);
                else
                {
                    d=(int)(Math.random()*6)+1;
                    System.out.println("You rolled a "+d);
                    if(ob.pos[i]+d<=100)
                    ob.pos[i]+=d;
                    if(c==1)
                    System.out.println("Position of "+s[i]+":"+ob.pos[i]);
                    else
                    System.out.println("Position of Player "+(i+1)+":"+ob.pos[i]);
                    int f=ob.check_snake(i);
                    if(f==1)
                    {
                        System.out.println("Oops!A Snake bit you");
                        if(c==1)
                        System.out.println("Position of "+s[i]+":"+ob.pos[i]);
                        else
                        System.out.println("Position of Player "+(i+1)+":"+ob.pos[i]);
                    }
                    f=ob.check_lad(i);
                    if(f==1)
                    {
                        System.out.println("Woah!You got a ladder.\nYou again get a chance to roll the die.");
                        if(c==1)
                        System.out.println("Position of "+s[i]+":"+ob.pos[i]);
                        else
                        System.out.println("Position of Player "+(i+1)+":"+ob.pos[i]);
                        System.out.println("Roll the die again");
                        i--;
                        continue;
                    }
                    if(ob.pos[i]>pmax)
                    pmax=ob.pos[i];   
                }
                if(pmax==100)
                break;
            }
        }
        if(c==1)
        System.out.println("Congratulations "+s[i]+" You Won!");
        else
        System.out.println("Congratulations Player "+(i+1)+" You Won!");
        System.out.println("Game Ends.Thank You for playing.");
        System.out.println("Enter any number to restart a newgame else input 0 to exit.");
        ch=sc.nextInt();
    }
    }
}