/*
Maximiliano Maurente
COP 4710
A simple database in Java
*/

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class P1 
{	
	/* Define data structures for holding the data here */
	//Define Map or arrays ::: HashMap<String ID, Obj>
	public class Coach
    {
        String first_name;
        String last_name;
        String season_win;
        String season_loss;
        String playoff_win;
        String playoff_loss;
        String team;
        String season;
        String id;

        public Coach(String eyeD, String seasoN, String firstName, 
                        String lastName, String seasonWin,
                        String seasonLoss, String playoffWin, 
                        String playoffLoss, String teaM)
        {
            first_name = firstName;
            last_name = lastName;
            season_win = seasonWin;
            season_loss = seasonLoss;
            playoff_win = playoffWin;
            playoff_loss = playoffLoss;
            team = teaM;
            season = seasoN;
            id = eyeD;
        }

        public String getLastName()
        {
            return last_name;
        }
        public String getSeason()
        {
            return season;
        }
        public String getId()
        {
            return id;
        }
        public String getTeam()
        {
            return team;
        }
        public String getSeasonWin()
        {
            return season_win;
        }
        public String getSeasonLoss()
        {
            return season_loss;
        }
        public String getPlayoffWin()
        {
            return playoff_win;
        }
        public String getPlayoffLoss()
        {
            return playoff_loss;
        }
        public void Print_Coach()
        {
            System.out.println(id + ", " + season + ", " + first_name + ", " + 
                            last_name + ", " + season_win + ", " + season_loss + ", " + 
                            playoff_win + ", " + playoff_loss + ", " + team); 
        }
    }

    public class Team
    {
        String team;
        String location;
        String tName;
        String league;

        public Team(String _team, String _loc, String _name, String _league)
        {
            team = _team;
            location = _loc;
            tName = _name;
            league = _league;
        }
        public String getLoc()
        {
            return location;
        }
        public String getName()
        {
            return tName;
        }
        public String getLeague()
        {
            return league;
        }
        public void Print_Team()
        {
            System.out.println(team + ", " + location + ", " + tName + ", " + league);
        }
    }

    ///*CoachesVect is a class that holds a Vector<Coach>,
    //the class functions all act on this Vector<Coach>
    //The Coach class is described above.
    //*/
    public class CoachesVect
    {
        Vector<Coach> cVect;

        public CoachesVect(int x)
        {
            cVect = new Vector<Coach>(x);
        }
        
		///*Add_Coach is the only function that can update the cVect.
        //Here we also check every input 
        //*/
        public void Add_Coach(String id, String seasoN, String firstName, 
                        String lastName, String seasonWin, String seasonLoss,
                        String playoffWin, String playoffLoss, String teaM)
        {
            boolean bID = false;
            boolean bSeason = false;
            boolean bFirstName = false;
            boolean bLastName = false;
            boolean bSeasonWin = false;
            boolean bSeasonLoss = false;
            boolean bPlayoffWin = false;
            boolean bPlayoffLoss = false;
            boolean bTeam = false;

            //check ID nt season_loss;
            //This ID 
            int intCount = id.replaceAll("\\D", "").length();
            int chCount = id.length() - intCount;

            if(chCount > 7 || intCount > 2) 
                System.out.println("Incorrect Input: ID Field can only have 7 characters and 2 integers. \"" + firstName + " " + 
                                lastName + "\" was not added bc ID = " + id);
            else bID = true;

            intCount = chCount = 0;
            //check params[1] for season
            Pattern pattern1 = Pattern.compile("[0-9]*");
            Matcher matcher1 = pattern1.matcher(seasoN);
            
            if(!matcher1.matches())
            {
                 System.out.println("Incorrect Input: Season can only take integers.\"" + firstName + " " + 
                                lastName + "\" was not added because season = " + seasoN);
            }
            else bSeason = true;
    
            
            //check params[2] for firstname
            Pattern pattern2 = Pattern.compile("[a-zA-Z\']*");
            Matcher matcher2 = pattern2.matcher(firstName);
            if (!matcher2.matches()) 
            {
                System.out.println("Incorrect Input: FirstName should not have special charcters or integers.\"" + firstName + " " + 
                                lastName + "\" was not added." + "\n");
            }
            else bFirstName = true;

            
            //check params[3] for lastname
            //Allows for whitespaces **the space after\'
            //Take Lastname -> replaceAll + with ' '  ->
            String newLN = lastName.replaceAll("\\+", " "); 
            Pattern pattern3 = Pattern.compile("[a-zA-Z\' ]*");
            Matcher matcher3 = pattern3.matcher(newLN);
            if (!matcher3.matches()) 
            {
                System.out.println("Incorrect Input: LastName should not have special charcters or integers.\"" + firstName + " " + 
                                newLN + "\" was not added." + "\n");
            }
            else bLastName = true;

            
            //check params[4] for sesonWin
            //Should only be integers
            Pattern pattern4 = Pattern.compile("[0-9]*");
            Matcher matcher4 = pattern4.matcher(seasonWin);
            if (!matcher4.matches()) 
            {
                System.out.println("Incorrect Input: SeasonwWins should only be integers.\"" + firstName + " " + 
                                lastName + "\" was not added because seasonWin = " + seasonWin + "\n");
            }
            else bSeasonWin = true;

            //check params[5] for seasonLoss
            //Should only be integers
            Matcher matcher5 = pattern4.matcher(seasonLoss);
            if (!matcher5.matches()) 
            {
                System.out.println("Incorrect Input: SeasonLoss should only be integers.\"" + firstName + " " + 
                                lastName + "\" was not added because seasonLoss = " + seasonLoss + "\n");
            }
            else bSeasonLoss = true;

            //check params[6] for playoffWin
            //Should only be integers
            Matcher matcher6 = pattern4.matcher(playoffWin);
            if (!matcher6.matches()) 
            {
                System.out.println("Incorrect Input: playoffWin should only be integers.\"" + firstName + " " + 
                                lastName + "\" was not added because playoffWin = " + playoffWin + "\n");
            }
            else bPlayoffWin = true;

            //check params[7] for playoffLoss
            //Should only be integers
            Matcher matcher7 = pattern4.matcher(playoffLoss);
            if (!matcher7.matches()) 
            {
                System.out.println("Incorrect Input: playoffLoss should only be integers.\"" + firstName + " " + 
                                lastName + "\" was not added because playoffLoss = " + playoffLoss + "\n");
            }
            else bPlayoffLoss = true;

            //check params[8] for team
            Pattern pattern8 = Pattern.compile("[A-Z0-9]*");
            Matcher matcher8 = pattern8.matcher(teaM);
            if (!matcher8.matches()) 
            {
                System.out.println("Incorrect Input: Team is only uppercase letters or integers.\"" + firstName + " " + 
                                lastName + "\" was not added because team = " + teaM + "\n");
            }
            else bTeam = true;


            Coach newCoach = new Coach(id, seasoN, firstName, 
                        newLN, seasonWin,
                        seasonLoss, playoffWin, 
                        playoffLoss, teaM);

            if(bID && bSeason && bFirstName && bLastName && bSeasonWin && bSeasonLoss && bPlayoffWin && bPlayoffWin)
            {
                cVect.addElement(newCoach);
                //System.out.println("NEW COACH ADDED :: " + firstName);
            }
        }

        ///*Load_Coaches accesses a given file and uses String.splt() 
        //method to split the comma seperated values. Repeatedly calls Add_Coach 
        //on every line of the text file. */
        public void Load_Coaches(String fileName)
        {
            int i = 0;
            //This will ref one line at a time
            String line = null;
            try
            {
                //FileReaderreads text files in default encoding
                FileReader fileRead = new FileReader(fileName);
                //wrap FileReader in BuffReader
                BufferedReader buffRead = new BufferedReader(fileRead);

                boolean firstIter = true;
                
                while((line = buffRead.readLine()) != null ) 
                {
                    if(firstIter == false)
                    {
                        String[] cValues = line.split(",");

                        Add_Coach(cValues[0].trim(), cValues[1], cValues[3], 
                                    cValues[4], cValues[5], cValues[6],
                                        cValues[7], cValues[8], cValues[9]);
                        i++;
                    }

                    firstIter = false;
                    
                }

                buffRead.close();

            }
            catch(IOException ex)
            {
                System.out.println(
                "Unable to open file '" + 
                fileName + "'");
            }
            System.out.println(i + " coaches have been successfully added to mini-DB");
        }

        ///*Print_Coaches calls a Coach class function in a loop to 
        //iteratively print out the coaches in cVect */
        public void Print_Coaches()
        {
            if(cVect.isEmpty())
            {
                System.out.println("Database is empty");
            }
            int i = 0;
            for(Coach c : cVect)
            {
                i++;
                c.Print_Coach();
            }
            System.out.println(i);
        }

        //Coach_ByName returns all coaches by the lastname that is passed in.
        //First, we know that we store names in the DB with white spaces. 
        //-----> So we replace the + sign whitespaces.
        //Second, we go through a for loop:
        //-----> we print out the coaches that match the name passed through(the updated version sName)
        public void Coach_ByName(String name)
        {
            //System.out.println(name);
            String sName = name.replaceAll("\\+", " ");
            //System.out.println(sName);
            Vector<String> cNames = new Vector<String>();

            boolean b = false;

            for(int i = 0; i < cVect.size(); i++)
            { 
                cNames.addElement(cVect.get(i).last_name);
                if(cVect.get(i).getLastName().equals(sName))
                {
                    cVect.get(i).Print_Coach();
                }
                //System.out.println(c.last_name);
            }
            int index = cNames.indexOf(name);
            //cVect.get(index).Print_Coach();
            
            cNames.clear();
        }

        //Best_Coach returns the best coach of the season (which ispassed as the only arg)
        //First it populates a vector of Coach objs with objs from cVect that qualify with values for season
        //Second, we go through the new vector and calculate the highest net score.
        //----->We do this in a for loop
        //-----------> 1)if the value at cVect[i] is greater that the previous, update score. Score starts with valu of 0
        //-----------> 2)only update index when we update 'score'.
        // We then print the coach at that index
        public void Best_Coach(String _season)
        {
            //String sName = name.trim();
            Vector<Coach> bCoach = new Vector<Coach>();

            boolean b = false;
            
            //filter cVect into coaches in given season put in bCoach
            for(int i = 0; i < cVect.size(); i++)
            {       
                if(cVect.get(i).getSeason().equals(_season))
                {
                    //cVect.get(i).Print_Coach();
                    bCoach.addElement(cVect.get(i));
                }
                //System.out.print("\"" + cVect.get(i).getSeason() + "\" and \""  + _season + "\""); 

            }   

            int score = 0;
            int index = 0;
            //Calculate each coaches score.
            for(int i = 0; i < bCoach.size(); i++)
            {
                if(score < Integer.parseInt(bCoach.get(i).season_win) - Integer.parseInt(bCoach.get(i).season_loss) + Integer.parseInt(bCoach.get(i).playoff_win) - Integer.parseInt(bCoach.get(i).playoff_loss))
                {
                    index = i;
                    score = Integer.parseInt(bCoach.get(i).season_win) - Integer.parseInt(bCoach.get(i).season_loss) + Integer.parseInt(bCoach.get(i).playoff_win) - Integer.parseInt(bCoach.get(i).playoff_loss);
                }
                //cVect.get(i).Print_Coach();

                //System.out.println(score);
            }

            bCoach.get(index).Print_Coach();

            bCoach.clear();
            bCoach.trimToSize();
        }

        //for last_name case we replace any '+' with ' ' to match what is in our DB
        //Search Coach is a big for loop with diff cases inside of it. Each case is 
        //----->described with an if statement which can tell what field is being used as 
        //----->a search parameter. In each field case, we have two cases:
        //------------>1)it is the first parameter passed.
        //-------------------->In this case, we parse cVect and add qualifying elements to cs
        //------------>2)it is not the first parameter passed
        //-------------------->we remove any unqualifying coaches.
        //At the end, we print out the cs vector of Coach objs that qualify with the params
        public void Search_Coach(String[] params)
        {
            //Coach result = new Coach();
            Vector<Coach> cs = new Vector<Coach>();
            int p = params.length;
            //System.out.println(p);
            for(int i = 0; i < p; i++)
            {
                String[] splits = params[i].split("=");
                
                //
                if(params[i].contains("coachID"))
                {
                    //System.out.println(params[i]);
                    //String[] splits = params[i].split("=");
                    if(splits.length != 2)
                    {
                        System.out.println("Incorrect input. Insert field ie:: coachID=\'   \'");
                    }
                    else
                    {
                        //System.out.println(cs.size());
                        //search for & remove coaches without the field
                        for(Coach c : cVect)
                        {
                            if(i==0)
                            {
                                //System.out.println(params[i]);
                                if(c.getId().equals(splits[1]))
                                {
                                    //int c1 = cs.indexOf(c);
                                    //System.out.println(c1);
                                    cs.addElement(c);
                                    //c.Print_Coach();
                                }
                            }
                            else
                            {
                                if(!c.getId().equals(splits[1]))
                                {
                                    cs.remove(c);
                                }
                            }
                        }
                    }
                        //System.out.println("splits[1]" + splits[1]);
                }
                //
                if(params[i].contains("year"))
                {
                    //System.out.println(params[i]);
                    //String[] splits = params[i].split("=");
                    if(splits.length != 2)
                    {
                        System.out.println("Incorrect input. Insert field ie:: coachID='ID'\'   \'");
                    }
                    else
                    {
                        //System.out.println(cs.size());
                        //search for & remove coaches without the field
                        for(Coach c : cVect)
                        {
                            if(i==0)
                            {
                                //System.out.println(params[i]);
                                if(c.getSeason().equals(splits[1]))
                                {
                                    //int c1 = cs.indexOf(c);
                                    //System.out.println(c1);
                                    cs.addElement(c);
                                    //c.Print_Coach();
                                }
                            }
                            else
                            {
                                if(!c.getSeason().equals(splits[1]))
                                {
                                    cs.remove(c);
                                }
                            }
                        }
                        //cs = select(cVect, having(on(Coach.class).getYear(), c.getSeason().equals(splits[1])));
                    }
                }

                //DONE
                if(params[i].contains("first_name"))
                {
                    //System.out.println(params[i]);
                    //String[] splits = params[i].split("=");
                    if(splits.length != 2)
                    {
                        System.out.println("Incorrect input. Insert field ie:: coachID=\'   \'");
                    }
                    else
                    {
                        //search for & remove coaches without the field
                        for(Coach c : cVect)
                        {
                            if(i==0)
                            {
                                //System.out.println(params[i]);
                                if(c.first_name.equals(splits[1]))
                                {
                                    //int c1 = cs.indexOf(c);
                                    //System.out.println(c1);
                                    cs.addElement(c);
                                    //c.Print_Coach();
                                }
                            }
                            else
                            {
                                if(!c.first_name.equals(splits[1]))
                                {
                                    cs.remove(c);
                                }
                            }
                        }
                        
                    } 
                }

                //Replaces any '+' with ' ' 
                //DONE
                if(params[i].contains("last_name"))
                {   
                    String lName;
                    //System.out.println(params[i]);
                    //String[] splits = params[i].split("=");
                    if(splits[1].contains("+"))
                    {
                        System.out.println(splits[1]);
                        lName = splits[1].replaceAll("\\+", " ");
                        System.out.println(lName);
                    }
                    else
                    {
                        lName = splits[1];
                    }
                    if(splits.length != 2)
                    {
                        System.out.println("Incorrect input. Insert field ie:: coachID=\'   \'");
                    }
                    else
                    {
                        //search for & remove coaches without the field
                        for(Coach c : cVect)
                        {
                            if(i==0)
                            {
                                //System.out.println(params[i]);
                                if(c.last_name.equals(lName))
                                {
                                    //int c1 = cs.indexOf(c);
                                    //System.out.println(c1);
                                    cs.addElement(c);
                                    //c.Print_Coach();
                                }
                            }
                            else
                            {
                                if(!c.last_name.equals(lName))
                                {
                                    cs.remove(c);
                                }
                            }
                        }
                        
                    } 
                    
                }
                //
                if(params[i].contains("season_win"))
                {
                    //System.out.println(params[i]);
                    //String[] splits = params[i].split("=");
                    if(splits.length != 2)
                    {
                        System.out.println("Incorrect input. Insert field ie:: coachID=\'   \'");
                    }
                    else
                    {
                        //search for & remove coaches without the field
                        for(Coach c : cVect)
                        {
                            if(i==0)
                            {
                                //System.out.println(params[i]);
                                if(c.getSeasonWin().equals(splits[1]))
                                {
                                    //int c1 = cs.indexOf(c);
                                    //System.out.println(c1);
                                    cs.addElement(c);
                                    //c.Print_Coach();
                                }
                            }
                            else
                            {
                                if(!c.getSeasonWin().equals(splits[1]))
                                {
                                    cs.remove(c);
                                }
                            }
                        }
                        
                    } 
                }
                //
                if(params[i].contains("season_loss"))
                {
                    //System.out.println(params[i]);
                    //String[] splits = params[i].split("=");
                    if(splits.length != 2)
                    {
                        System.out.println("Incorrect input. Insert field ie:: coachID=\'   \'");
                    }
                    else
                    {
                        //search for & remove coaches without the field
                        for(Coach c : cVect)
                        {
                            if(i==0)
                            {
                                //System.out.println(params[i]);
                                if(c.getSeasonLoss().equals(splits[1]))
                                {
                                    //int c1 = cs.indexOf(c);
                                    //System.out.println(c1);
                                    cs.addElement(c);
                                    //c.Print_Coach();
                                }
                            }
                            else
                            {
                                if(!c.getSeasonLoss().equals(splits[1]))
                                {
                                    cs.remove(c);
                                }
                            }
                        }
                        
                    } 
                }
                //
                if(params[i].contains("playoff_win"))
                {
                   //System.out.println(params[i]);
                   // String[] splits = params[i].split("=");
                    if(splits.length != 2)
                    {
                        System.out.println("Incorrect input. Insert field ie:: coachID=\'   \'");
                    }
                    else
                    {
                        for(Coach c : cVect)
                        {
                            if(i==0)
                            {
                                //System.out.println(params[i]);
                                if(c.getPlayoffWin().equals(splits[1]))
                                {
                                    //int c1 = cs.indexOf(c);
                                    //System.out.println(c1);
                                    cs.addElement(c);
                                    //c.Print_Coach();
                                }
                            }
                            else
                            {
                                if(!c.getPlayoffWin().equals(splits[1]))
                                {
                                    cs.remove(c);
                                }
                            }
                        }
                        
                    } 
                }   
                //
                if(params[i].contains("playoff_loss"))
                {
                    //System.out.println(params[i]);
                    //String[] splits = params[i].split("=");
                    if(splits.length != 2)
                    {
                        System.out.println("Incorrect input. Insert field ie:: coachID=\'   \'");
                    }
                    else
                    {
                        for(Coach c : cVect)
                        {
                            if(i==0)
                            {
                                //System.out.println(params[i]);
                                if(c.getPlayoffLoss().equals(splits[1]))
                                {
                                    //int c1 = cs.indexOf(c);
                                    //System.out.println(c1);
                                    cs.addElement(c);
                                    //c.Print_Coach();
                                }
                            }
                            else
                            {
                                if(!c.getPlayoffLoss().equals(splits[1]))
                                {
                                    cs.remove(c);
                                }
                            }
                        }
                        
                    } 
                }
                //
                if(params[i].contains("team"))
                {
                   //System.out.println(params[i]);
                    //String[] splits = params[i].split("=");
                    if(splits.length != 2)
                    {
                        System.out.println("Incorrect input. Insert field ie:: coachID=\'   \'");
                    }
                    else
                    {
                        for(Coach c : cVect)
                        {
                            if(i == 0)
                            {
                                //System.out.println(params[i]);
                                if(c.getTeam().equals(splits[1]))
                                {
                                    //int c1 = cs.indexOf(c);
                                    //System.out.println(c1);
                                    cs.addElement(c);
                                   //c.Print_Coach();
                                }
                            }
                            else
                            {
                                if(!c.getTeam().equals(splits[1]))
                                {
                                    cs.remove(c);
                                }
                            }
                        }
                        
                    } 
                }
            }

            int count = 0;
            for(int i = 0; i < cs.size(); i++)
            {
                count++;
                cs.get(i).Print_Coach();
            }
            //System.out.println(count);
            if(count == 0)
                System.out.println("Remember that names are case sensitive");
        }

    }
    
    //TeamsVect holds a Vector of Team objs.
	public class TeamsVect
	{
        Vector<Team> teamVect;

        public TeamsVect(int x)
        {
            teamVect = new Vector<Team>(x);
        }

        ///*Add_Team is the only function that can update the cVect.
        //Here we also check every input 
        public void Add_Team(String _team, String _loc, String _name, String _league)
        {
            //Input check
            boolean bTeam = false;
            boolean bLocation = false;
            boolean bName = false;
            boolean bLeague = false;

            //TESTING _team input 
            // add_team JaAM Kings+Town Jammis A
            Pattern pattern = Pattern.compile("[1-9A-Z]*");
            Matcher matcher = pattern.matcher(_team);
            if (!matcher.matches()) 
            {
                System.out.println("Incorrect Input: ID should only have capital letters or digits.\"" + _team + " " + 
                                _name + "\" was not added.");
            }
            else bTeam = true;

            //TESTING __loc input 
            // add_team JAM KingsTown Jammis A
            String newLoc = _loc.replaceAll("\\+", " "); 
            Pattern pattern2 = Pattern.compile("[a-zA-Z\\. ]*");
            Matcher matcher2 = pattern2.matcher(newLoc);
            if (!matcher2.matches()) 
            {
                System.out.println("Incorrect Input: Location should only have  '.' or a-z or A-Z.\"" + _team + " " + 
                                _name + "\" was not added.");
            }
            else bLocation = true;

            //TESTING _name input 
            // add_team JaAM Kings+Town Jammis A
            String newName = _name.replaceAll("\\+", " "); 
            Pattern pattern3 = Pattern.compile("[a-zA-Z ]*");
            Matcher matcher3 = pattern3.matcher(newName);
            if (!matcher3.matches()) 
            {
                System.out.println("Incorrect Input: Team name should be one word and only have letters in it.\"" + _team + " " + 
                                newName + "\" was not added.");
            }
            else bName = true;

            //TESTING _league input 
            // add_team JAM Kings+Town Jammis P
            Pattern pattern4 = Pattern.compile("[A-Z]*");
            Matcher matcher4 = pattern4.matcher(_league);
            if (!matcher4.matches()) 
            {
                System.out.println("Incorrect Input: Location should only have  '.' or a-z or A-Z.\"" + _team + " " + 
                                newName + "\" was not added.");
            }
            else bLeague = true;
            

            Team newT = new Team(_team, newLoc, newName, _league);
            //Add Team
            if(bTeam && bLocation && bName && bLeague)
            {
                //System.out.println("successfully added");
                teamVect.addElement(newT);
            }
            else newT.Print_Team();
        }

        ///*Load_Team accesses a given file and uses String.splt() 
        //method to split the comma seperated values. Repeatedly calls Add_Team 
        //on every line of the text file. */
		public void Load_Team(String fileName)
        {
            int i = 0;
            //This will ref one line at a time
            String line = null;
            try
            {
                //FileReaderreads text files in default encoding
                FileReader fileRead = new FileReader(fileName);
                //wrap FileReader in BuffReader
                BufferedReader buffRead = new BufferedReader(fileRead);

                boolean firstIter = true;
                
                while((line = buffRead.readLine()) != null ) 
                {
                    if(firstIter == false)
                    {
                        String[] cValues = line.split(",");

                        Add_Team(cValues[0], cValues[1], cValues[2], cValues[3]);
                        i++;
                    }

                    firstIter = false;
                    
                }

                buffRead.close();
            }
            catch(IOException ex)
            {
                System.out.println(
                "Unable to open file '" + 
                fileName + "'");
            }
            System.out.println(i + " coaches have been successfully added to mini-DB");
        }

        public void Print_Teams()
        {
            if(teamVect.isEmpty())
            {
                System.out.println("Database is empty");
            }
            int i = 0;
            for(Team t : teamVect)
            {
                i++;
                t.Print_Team();
            }
            System.out.println(i);

        }

        public void Team_ByCity(String _loc)
        {
            String sName = _loc.replaceAll("\\+", " ");
            Vector<Team> cNames = new Vector<Team>();

            boolean b = false;

            for(int i = 0; i < teamVect.size(); i++)
            { 
                cNames.addElement(teamVect.get(i));
                if(teamVect.get(i).getLoc().equals(sName))
                {
                    
                    cNames.get(i).Print_Team();
                }
                /*System.out.println(teamVect.get(i).team);
                System.out.println(sName);*/
            }
            int index = cNames.indexOf(sName);
            
            
            cNames.clear();
        }
	}
	

/*    public P1() 
    {
         initialize the data structures 
        CoachesVect CoachDB = new CoachesVect(0);

    }
    */
    public void run() 
    {
        //INITIALIZE HERE
        CoachesVect CoachDB = new CoachesVect(0);
        TeamsVect TeamDB = new TeamsVect(0);

        CommandParser parser = new CommandParser();

        System.out.println("The mini-DB of NBA coaches and teams");
        System.out.println("Please enter a command.  Enter 'help' for a list of commands.");
        System.out.println();
        System.out.print("> "); 
        
        Command cmd = null;
        while ((cmd = parser.fetchCommand()) != null) 
        {
            //System.out.println(cmd);
            
            boolean result=false;
            
            if (cmd.getCommand().equals("help")) 
            {
                result = doHelp();
            } 

            /* You need to implement all the following commands */

            //DONE
            else if (cmd.getCommand().equals("add_coach")) 
            {
                //for testing::
                /*
                    bad ID:: add_coach MAXMM94 2017 Maximiliano Maurente 100 100 200 300 URU
                    bad Season:: add_coach MAXM94 20a17 Maximiliano Maurente 100 100 200 300 URU
                    bad FN :: add_coach MAXM94 2017 Maxi5miliano Maurente 100 100 200 300 URU
                    bad LN :: add_coach MAXM94 2017 Maximiliano Maur@nte 100 100 200 300 URU
                    bad SW :: add_coach MAXM94 2017 Maximiliano Maurente 10a0 100 200 300 URU
                    bad SL :: add_coach MAXM94 2017 Maximiliano Maurente 100 1e00 200 300 URU
                    bad PW :: add_coach MAXM94 2017 Maximiliano Maurente 100 100 2w00 300 URU
                    bad PL :: add_coach MAXM94 2017 Maximiliano Maurente 100 100 200 3q00 URU
                    bad Team :: add_coach MAXM94 2017 Maximiliano Maurente 100 100 200 300 U9aRU


                */

                String[] params = cmd.getParameters();

                //check for correct num of params
                if(params.length != 9) 
                {
                    System.out.println("Incorrect Input: wrong number of args");
                    
                }
                else 
                {
                    CoachDB.Add_Coach(params[0], params[1], params[2], 
                                    params[3], params[4], params[5], 
                                    params[6], params[7], params[8]);
                }  
    	    } 

            //DONE
            else if (cmd.getCommand().equals("add_team")) 
            {
                //for testing::
                /*
                    load_teams teams.txt
                    add_team URU Montevideo Nacional A
                */

            	String[] params = cmd.getParameters();

                //check for correct num of params
                if(params.length != 4) 
                {
                    System.out.println("Incorrect Input: wrong number of args");
                    
                }
                else 
                {
                    TeamDB.Add_Team(params[0], params[1], params[2], 
                                    params[3]);
                }  
    		} 

            //DONE
            else if (cmd.getCommand().equals("print_coaches")) 
            {
                CoachDB.Print_Coaches();
    	   	} 
            //DONE
            else if (cmd.getCommand().equals("print_teams")) 
            {
                TeamDB.Print_Teams();
    		} 

            //DONE
            else if (cmd.getCommand().equals("coaches_by_name")) 
            {
                //for testing::
                /*
                    load_coaches coaches_season.txt
                    coaches_by_name Sloan
                */

                String[] params = cmd.getParameters();
                String name = params[0];
                CoachDB.Coach_ByName(name);
                //System.out.println(name);
    		} 
            
            //Figure out how to implement with + as space
            else if (cmd.getCommand().equals("teams_by_city")) 
            {
                //for testing::
                /*
                    load_teams teams.txt
                    teams_by_city
                */

                String[] params = cmd.getParameters();
                String name = params[0];
                TeamDB.Team_ByCity(name);
    		} 

            //DONE
            else if (cmd.getCommand().equals("load_coaches")) 
            {
                //for testing::
                /*
                    
                */
                String[] params = cmd.getParameters();
                if(params.length == 0)
                {
                    System.out.println("Please insert file name");
                }
                else
                {
                    String fName = params[0];
                    CoachDB.Load_Coaches(fName);
                    //CoachDB.Print_Coaches();
                } 
            } 

            //DONE
            else if (cmd.getCommand().equals("load_teams")) 
            {
                //for testing::
                /*
                    load_teams teams.txt
                */
                String[] params = cmd.getParameters();
                if(params.length == 0)
                {
                    System.out.println("Please insert file name");
                }
                else
                {
                    String fName = params[0];
                    TeamDB.Load_Team(fName);  
                }
    		} 

            //DONE
            else if (cmd.getCommand().equals("best_coach")) 
            {
                //for testing::
                /*
                    load_coaches coaches_season.txt
                    best_coach 2000
                */

                String[] params = cmd.getParameters();
                String seas = params[0];
                CoachDB.Best_Coach(seas);
    		} 

            //DONE
            else if (cmd.getCommand().equals("search_coaches")) 
            {
                //for testing::
                /*
                    load_coaches coaches_season.txt
                    search_coaches coachID=KRUGELO01
                */
                
                String[] params = cmd.getParameters();
                CoachDB.Search_Coach(params);
    		} 

            else if (cmd.getCommand().equals("exit")) 
            {
    			System.out.println("Leaving the database, goodbye!");
    			break;
    		} 

            else if (cmd.getCommand().equals("")) 
            {

    		} 
            else 
            {
    			System.out.println("Invalid Command, try again!");
            } 
                
    	    if (result) 
            {
                    // ...
            }

            System.out.print("> "); 
        }        
    }
    
    private boolean doHelp() 
    {
        System.out.println("add_coach ID SEASON FIRST_NAME LAST_NAME SEASON_WIN "); 
	    System.out.println("          EASON_LOSS PLAYOFF_WIN PLAYOFF_LOSS TEAM - add new coach data");
        System.out.println("add_team ID LOCATION NAME LEAGUE - add a new team");
        System.out.println("print_coaches - print a listing of all coaches");
        System.out.println("print_teams - print a listing of all teams");
        System.out.println("coaches_by_name NAME - list info of coaches with the specified name");
        System.out.println("teams_by_city CITY - list the teams in the specified city");
	    System.out.println("load_coach FILENAME - bulk load of coach info from a file");
        System.out.println("load_team FILENAME - bulk load of team info from a file");
        System.out.println("best_coach SEASON - print the name of the coach with the most netwins in a specified season");
        System.out.println("search_coaches field=VALUE - print the name of the coach satisfying the specified conditions");
		System.out.println("exit - quit the program");        
        return true;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        new P1().run();
    }
}
