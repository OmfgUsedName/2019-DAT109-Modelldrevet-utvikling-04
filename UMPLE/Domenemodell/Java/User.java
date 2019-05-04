/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.util.*;

// line 13 "model.ump"
// line 34 "model.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private int id;
  private String name;
  private String type;

  //User Associations
  private Exhibition exhibition;
  private List<Vote> votes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(int aId, String aName, String aType, Exhibition aExhibition)
  {
    id = aId;
    name = aName;
    type = aType;
    boolean didAddExhibition = setExhibition(aExhibition);
    if (!didAddExhibition)
    {
      throw new RuntimeException("Unable to create user due to exhibition");
    }
    votes = new ArrayList<Vote>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getType()
  {
    return type;
  }
  /* Code from template association_GetOne */
  public Exhibition getExhibition()
  {
    return exhibition;
  }
  /* Code from template association_GetMany */
  public Vote getVote(int index)
  {
    Vote aVote = votes.get(index);
    return aVote;
  }

  public List<Vote> getVotes()
  {
    List<Vote> newVotes = Collections.unmodifiableList(votes);
    return newVotes;
  }

  public int numberOfVotes()
  {
    int number = votes.size();
    return number;
  }

  public boolean hasVotes()
  {
    boolean has = votes.size() > 0;
    return has;
  }

  public int indexOfVote(Vote aVote)
  {
    int index = votes.indexOf(aVote);
    return index;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setExhibition(Exhibition aExhibition)
  {
    boolean wasSet = false;
    //Must provide exhibition to user
    if (aExhibition == null)
    {
      return wasSet;
    }

    //exhibition already at maximum (4)
    if (aExhibition.numberOfUsers() >= Exhibition.maximumNumberOfUsers())
    {
      return wasSet;
    }
    
    Exhibition existingExhibition = exhibition;
    exhibition = aExhibition;
    if (existingExhibition != null && !existingExhibition.equals(aExhibition))
    {
      boolean didRemove = existingExhibition.removeUser(this);
      if (!didRemove)
      {
        exhibition = existingExhibition;
        return wasSet;
      }
    }
    exhibition.addUser(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfVotes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Vote addVote(int aId, Exhibition aExhibition)
  {
    return new Vote(aId, this, aExhibition);
  }

  public boolean addVote(Vote aVote)
  {
    boolean wasAdded = false;
    if (votes.contains(aVote)) { return false; }
    User existingUser = aVote.getUser();
    boolean isNewUser = existingUser != null && !this.equals(existingUser);
    if (isNewUser)
    {
      aVote.setUser(this);
    }
    else
    {
      votes.add(aVote);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVote(Vote aVote)
  {
    boolean wasRemoved = false;
    //Unable to remove aVote, as it must always have a user
    if (!this.equals(aVote.getUser()))
    {
      votes.remove(aVote);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addVoteAt(Vote aVote, int index)
  {  
    boolean wasAdded = false;
    if(addVote(aVote))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVotes()) { index = numberOfVotes() - 1; }
      votes.remove(aVote);
      votes.add(index, aVote);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVoteAt(Vote aVote, int index)
  {
    boolean wasAdded = false;
    if(votes.contains(aVote))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVotes()) { index = numberOfVotes() - 1; }
      votes.remove(aVote);
      votes.add(index, aVote);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVoteAt(aVote, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Exhibition placeholderExhibition = exhibition;
    this.exhibition = null;
    if(placeholderExhibition != null)
    {
      placeholderExhibition.removeUser(this);
    }
    for(int i=votes.size(); i > 0; i--)
    {
      Vote aVote = votes.get(i - 1);
      aVote.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "," +
            "type" + ":" + getType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "exhibition = "+(getExhibition()!=null?Integer.toHexString(System.identityHashCode(getExhibition())):"null");
  }
}