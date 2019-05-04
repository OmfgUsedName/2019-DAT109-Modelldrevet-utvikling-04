/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/



// line 2 "model.ump"
// line 79 "model.ump"
public class homePage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //homePage State Machines
  public enum LoginState { onLoginScreen, loggedIn, incorrectLogin, homePage }
  private LoginState loginState;
  public enum JuryPageState { homePage, exhibitionPage, admin, editExhibition, liveResultPage }
  private JuryPageState juryPageState;
  public enum ExpoPageState { homePage, myExhibitionPage, exhibitionPage, editExhibition, voteDetailsPage, database, liveResultPage }
  private ExpoPageState expoPageState;
  public enum SpectatorPageState { homePage, exhibitionPage, voteDetailsPage, database, liveResultPage }
  private SpectatorPageState spectatorPageState;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public homePage()
  {
    setLoginState(LoginState.onLoginScreen);
    setJuryPageState(JuryPageState.homePage);
    setExpoPageState(ExpoPageState.homePage);
    setSpectatorPageState(SpectatorPageState.homePage);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getLoginStateFullName()
  {
    String answer = loginState.toString();
    return answer;
  }

  public String getJuryPageStateFullName()
  {
    String answer = juryPageState.toString();
    return answer;
  }

  public String getExpoPageStateFullName()
  {
    String answer = expoPageState.toString();
    return answer;
  }

  public String getSpectatorPageStateFullName()
  {
    String answer = spectatorPageState.toString();
    return answer;
  }

  public LoginState getLoginState()
  {
    return loginState;
  }

  public JuryPageState getJuryPageState()
  {
    return juryPageState;
  }

  public ExpoPageState getExpoPageState()
  {
    return expoPageState;
  }

  public SpectatorPageState getSpectatorPageState()
  {
    return spectatorPageState;
  }

  public boolean correctLogin()
  {
    boolean wasEventProcessed = false;
    
    LoginState aLoginState = loginState;
    switch (aLoginState)
    {
      case onLoginScreen:
        setLoginState(LoginState.loggedIn);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean incorrectLoginInformation()
  {
    boolean wasEventProcessed = false;
    
    LoginState aLoginState = loginState;
    switch (aLoginState)
    {
      case onLoginScreen:
        setLoginState(LoginState.incorrectLogin);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean displayHomePage()
  {
    boolean wasEventProcessed = false;
    
    LoginState aLoginState = loginState;
    switch (aLoginState)
    {
      case loggedIn:
        setLoginState(LoginState.homePage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean displayError()
  {
    boolean wasEventProcessed = false;
    
    LoginState aLoginState = loginState;
    switch (aLoginState)
    {
      case incorrectLogin:
        setLoginState(LoginState.onLoginScreen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean selectsExhibiton()
  {
    boolean wasEventProcessed = false;
    
    JuryPageState aJuryPageState = juryPageState;
    ExpoPageState aExpoPageState = expoPageState;
    SpectatorPageState aSpectatorPageState = spectatorPageState;
    switch (aJuryPageState)
    {
      case homePage:
        setJuryPageState(JuryPageState.exhibitionPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aExpoPageState)
    {
      case homePage:
        setExpoPageState(ExpoPageState.exhibitionPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSpectatorPageState)
    {
      case homePage:
        setSpectatorPageState(SpectatorPageState.exhibitionPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean selectsAdmin()
  {
    boolean wasEventProcessed = false;
    
    JuryPageState aJuryPageState = juryPageState;
    switch (aJuryPageState)
    {
      case homePage:
        setJuryPageState(JuryPageState.admin);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean selectsLiveResult()
  {
    boolean wasEventProcessed = false;
    
    JuryPageState aJuryPageState = juryPageState;
    ExpoPageState aExpoPageState = expoPageState;
    SpectatorPageState aSpectatorPageState = spectatorPageState;
    switch (aJuryPageState)
    {
      case homePage:
        setJuryPageState(JuryPageState.liveResultPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aExpoPageState)
    {
      case homePage:
        setExpoPageState(ExpoPageState.liveResultPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSpectatorPageState)
    {
      case homePage:
        setSpectatorPageState(SpectatorPageState.liveResultPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean editExhibitionTeam()
  {
    boolean wasEventProcessed = false;
    
    JuryPageState aJuryPageState = juryPageState;
    switch (aJuryPageState)
    {
      case admin:
        setJuryPageState(JuryPageState.editExhibition);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean addTeamMember()
  {
    boolean wasEventProcessed = false;
    
    JuryPageState aJuryPageState = juryPageState;
    ExpoPageState aExpoPageState = expoPageState;
    switch (aJuryPageState)
    {
      case editExhibition:
        setJuryPageState(JuryPageState.editExhibition);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aExpoPageState)
    {
      case editExhibition:
        setExpoPageState(ExpoPageState.editExhibition);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean changeExhibitionDetails()
  {
    boolean wasEventProcessed = false;
    
    JuryPageState aJuryPageState = juryPageState;
    ExpoPageState aExpoPageState = expoPageState;
    switch (aJuryPageState)
    {
      case editExhibition:
        setJuryPageState(JuryPageState.editExhibition);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aExpoPageState)
    {
      case editExhibition:
        setExpoPageState(ExpoPageState.editExhibition);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean editMyExhibition()
  {
    boolean wasEventProcessed = false;
    
    ExpoPageState aExpoPageState = expoPageState;
    switch (aExpoPageState)
    {
      case homePage:
        setExpoPageState(ExpoPageState.myExhibitionPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean edit()
  {
    boolean wasEventProcessed = false;
    
    ExpoPageState aExpoPageState = expoPageState;
    switch (aExpoPageState)
    {
      case myExhibitionPage:
        setExpoPageState(ExpoPageState.editExhibition);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean sendVote()
  {
    boolean wasEventProcessed = false;
    
    ExpoPageState aExpoPageState = expoPageState;
    SpectatorPageState aSpectatorPageState = spectatorPageState;
    switch (aExpoPageState)
    {
      case exhibitionPage:
        setExpoPageState(ExpoPageState.voteDetailsPage);
        wasEventProcessed = true;
        break;
      case voteDetailsPage:
        setExpoPageState(ExpoPageState.database);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSpectatorPageState)
    {
      case exhibitionPage:
        setSpectatorPageState(SpectatorPageState.voteDetailsPage);
        wasEventProcessed = true;
        break;
      case voteDetailsPage:
        setSpectatorPageState(SpectatorPageState.database);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean newVote()
  {
    boolean wasEventProcessed = false;
    
    ExpoPageState aExpoPageState = expoPageState;
    SpectatorPageState aSpectatorPageState = spectatorPageState;
    switch (aExpoPageState)
    {
      case database:
        setExpoPageState(ExpoPageState.exhibitionPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSpectatorPageState)
    {
      case database:
        setSpectatorPageState(SpectatorPageState.exhibitionPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean replaceOldVote()
  {
    boolean wasEventProcessed = false;
    
    ExpoPageState aExpoPageState = expoPageState;
    SpectatorPageState aSpectatorPageState = spectatorPageState;
    switch (aExpoPageState)
    {
      case database:
        setExpoPageState(ExpoPageState.exhibitionPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aSpectatorPageState)
    {
      case database:
        setSpectatorPageState(SpectatorPageState.exhibitionPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setLoginState(LoginState aLoginState)
  {
    loginState = aLoginState;
  }

  private void setJuryPageState(JuryPageState aJuryPageState)
  {
    juryPageState = aJuryPageState;
  }

  private void setExpoPageState(ExpoPageState aExpoPageState)
  {
    expoPageState = aExpoPageState;
  }

  private void setSpectatorPageState(SpectatorPageState aSpectatorPageState)
  {
    spectatorPageState = aSpectatorPageState;
  }

  public void delete()
  {}

}