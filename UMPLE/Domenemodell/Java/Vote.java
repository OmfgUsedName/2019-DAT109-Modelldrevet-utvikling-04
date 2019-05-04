/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/



// line 20 "model.ump"
// line 27 "model.ump"
public class Vote
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vote Attributes
  private int id;

  //Vote Associations
  private User user;
  private Exhibition exhibition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Vote(int aId, User aUser, Exhibition aExhibition)
  {
    id = aId;
    boolean didAddUser = setUser(aUser);
    if (!didAddUser)
    {
      throw new RuntimeException("Unable to create vote due to user");
    }
    boolean didAddExhibition = setExhibition(aExhibition);
    if (!didAddExhibition)
    {
      throw new RuntimeException("Unable to create vote due to exhibition");
    }
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

  public int getId()
  {
    return id;
  }
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
  }
  /* Code from template association_GetOne */
  public Exhibition getExhibition()
  {
    return exhibition;
  }
  /* Code from template association_SetOneToMany */
  public boolean setUser(User aUser)
  {
    boolean wasSet = false;
    if (aUser == null)
    {
      return wasSet;
    }

    User existingUser = user;
    user = aUser;
    if (existingUser != null && !existingUser.equals(aUser))
    {
      existingUser.removeVote(this);
    }
    user.addVote(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setExhibition(Exhibition aExhibition)
  {
    boolean wasSet = false;
    if (aExhibition == null)
    {
      return wasSet;
    }

    Exhibition existingExhibition = exhibition;
    exhibition = aExhibition;
    if (existingExhibition != null && !existingExhibition.equals(aExhibition))
    {
      existingExhibition.removeVote(this);
    }
    exhibition.addVote(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    User placeholderUser = user;
    this.user = null;
    if(placeholderUser != null)
    {
      placeholderUser.removeVote(this);
    }
    Exhibition placeholderExhibition = exhibition;
    this.exhibition = null;
    if(placeholderExhibition != null)
    {
      placeholderExhibition.removeVote(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "user = "+(getUser()!=null?Integer.toHexString(System.identityHashCode(getUser())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "exhibition = "+(getExhibition()!=null?Integer.toHexString(System.identityHashCode(getExhibition())):"null");
  }
}