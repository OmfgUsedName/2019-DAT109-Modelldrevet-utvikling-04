/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 39 "model.ump"
public class Exhibition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Exhibition Attributes
  private int id;
  private String name;
  private String description;
  private List<User> team;
  private List<String> urlPhoto;

  //Exhibition Associations
  private List<User> users;
  private List<Vote> votes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Exhibition(int aId, String aName, String aDescription)
  {
    id = aId;
    name = aName;
    description = aDescription;
    team = new ArrayList<User>();
    urlPhoto = new ArrayList<String>();
    users = new ArrayList<User>();
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

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetMany */
  public boolean addTeam(User aTeam)
  {
    boolean wasAdded = false;
    wasAdded = team.add(aTeam);
    return wasAdded;
  }

  public boolean removeTeam(User aTeam)
  {
    boolean wasRemoved = false;
    wasRemoved = team.remove(aTeam);
    return wasRemoved;
  }
  /* Code from template attribute_SetMany */
  public boolean addUrlPhoto(String aUrlPhoto)
  {
    boolean wasAdded = false;
    wasAdded = urlPhoto.add(aUrlPhoto);
    return wasAdded;
  }

  public boolean removeUrlPhoto(String aUrlPhoto)
  {
    boolean wasRemoved = false;
    wasRemoved = urlPhoto.remove(aUrlPhoto);
    return wasRemoved;
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }
  /* Code from template attribute_GetMany */
  public User getTeam(int index)
  {
    User aTeam = team.get(index);
    return aTeam;
  }

  public User[] getTeam()
  {
    User[] newTeam = team.toArray(new User[team.size()]);
    return newTeam;
  }

  public int numberOfTeam()
  {
    int number = team.size();
    return number;
  }

  public boolean hasTeam()
  {
    boolean has = team.size() > 0;
    return has;
  }

  public int indexOfTeam(User aTeam)
  {
    int index = team.indexOf(aTeam);
    return index;
  }
  /* Code from template attribute_GetMany */
  public String getUrlPhoto(int index)
  {
    String aUrlPhoto = urlPhoto.get(index);
    return aUrlPhoto;
  }

  public String[] getUrlPhoto()
  {
    String[] newUrlPhoto = urlPhoto.toArray(new String[urlPhoto.size()]);
    return newUrlPhoto;
  }

  public int numberOfUrlPhoto()
  {
    int number = urlPhoto.size();
    return number;
  }

  public boolean hasUrlPhoto()
  {
    boolean has = urlPhoto.size() > 0;
    return has;
  }

  public int indexOfUrlPhoto(String aUrlPhoto)
  {
    int index = urlPhoto.indexOf(aUrlPhoto);
    return index;
  }
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
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
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfUsersValid()
  {
    boolean isValid = numberOfUsers() >= minimumNumberOfUsers() && numberOfUsers() <= maximumNumberOfUsers();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 1;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfUsers()
  {
    return 4;
  }
  /* Code from template association_AddMNToOnlyOne */
  public User addUser(int aId, String aName, String aType)
  {
    if (numberOfUsers() >= maximumNumberOfUsers())
    {
      return null;
    }
    else
    {
      return new User(aId, aName, aType, this);
    }
  }

  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    if (numberOfUsers() >= maximumNumberOfUsers())
    {
      return wasAdded;
    }

    Exhibition existingExhibition = aUser.getExhibition();
    boolean isNewExhibition = existingExhibition != null && !this.equals(existingExhibition);

    if (isNewExhibition && existingExhibition.numberOfUsers() <= minimumNumberOfUsers())
    {
      return wasAdded;
    }

    if (isNewExhibition)
    {
      aUser.setExhibition(this);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    //Unable to remove aUser, as it must always have a exhibition
    if (this.equals(aUser.getExhibition()))
    {
      return wasRemoved;
    }

    //exhibition already at minimum (1)
    if (numberOfUsers() <= minimumNumberOfUsers())
    {
      return wasRemoved;
    }
    users.remove(aUser);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfVotes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Vote addVote(int aId, User aUser)
  {
    return new Vote(aId, aUser, this);
  }

  public boolean addVote(Vote aVote)
  {
    boolean wasAdded = false;
    if (votes.contains(aVote)) { return false; }
    Exhibition existingExhibition = aVote.getExhibition();
    boolean isNewExhibition = existingExhibition != null && !this.equals(existingExhibition);
    if (isNewExhibition)
    {
      aVote.setExhibition(this);
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
    //Unable to remove aVote, as it must always have a exhibition
    if (!this.equals(aVote.getExhibition()))
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
    for(int i=users.size(); i > 0; i--)
    {
      User aUser = users.get(i - 1);
      aUser.delete();
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
            "description" + ":" + getDescription()+ "]";
  }
}