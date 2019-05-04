<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class homePage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //homePage State Machines
  private static $LoginStateOnLoginScreen = 1;
  private static $LoginStateLoggedIn = 2;
  private static $LoginStateIncorrectLogin = 3;
  private static $LoginStateHomePage = 4;
  private $loginState;

  private static $JuryPageStateHomePage = 1;
  private static $JuryPageStateExhibitionPage = 2;
  private static $JuryPageStateAdmin = 3;
  private static $JuryPageStateEditExhibition = 4;
  private static $JuryPageStateLiveResultPage = 5;
  private $juryPageState;

  private static $ExpoPageStateHomePage = 1;
  private static $ExpoPageStateMyExhibitionPage = 2;
  private static $ExpoPageStateExhibitionPage = 3;
  private static $ExpoPageStateEditExhibition = 4;
  private static $ExpoPageStateVoteDetailsPage = 5;
  private static $ExpoPageStateDatabase = 6;
  private static $ExpoPageStateLiveResultPage = 7;
  private $expoPageState;

  private static $SpectatorPageStateHomePage = 1;
  private static $SpectatorPageStateExhibitionPage = 2;
  private static $SpectatorPageStateVoteDetailsPage = 3;
  private static $SpectatorPageStateDatabase = 4;
  private static $SpectatorPageStateLiveResultPage = 5;
  private $spectatorPageState;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->setLoginState(self::$LoginStateOnLoginScreen);
    $this->setJuryPageState(self::$JuryPageStateHomePage);
    $this->setExpoPageState(self::$ExpoPageStateHomePage);
    $this->setSpectatorPageState(self::$SpectatorPageStateHomePage);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getLoginStateFullName()
  {
    $answer = $this->getLoginState();
    return $answer;
  }

  public function getJuryPageStateFullName()
  {
    $answer = $this->getJuryPageState();
    return $answer;
  }

  public function getExpoPageStateFullName()
  {
    $answer = $this->getExpoPageState();
    return $answer;
  }

  public function getSpectatorPageStateFullName()
  {
    $answer = $this->getSpectatorPageState();
    return $answer;
  }

  public function getLoginState()
  {
    if ($this->loginState == self::$LoginStateOnLoginScreen) { return "LoginStateOnLoginScreen"; }
    elseif ($this->loginState == self::$LoginStateLoggedIn) { return "LoginStateLoggedIn"; }
    elseif ($this->loginState == self::$LoginStateIncorrectLogin) { return "LoginStateIncorrectLogin"; }
    elseif ($this->loginState == self::$LoginStateHomePage) { return "LoginStateHomePage"; }
    return null;
  }

  public function getJuryPageState()
  {
    if ($this->juryPageState == self::$JuryPageStateHomePage) { return "JuryPageStateHomePage"; }
    elseif ($this->juryPageState == self::$JuryPageStateExhibitionPage) { return "JuryPageStateExhibitionPage"; }
    elseif ($this->juryPageState == self::$JuryPageStateAdmin) { return "JuryPageStateAdmin"; }
    elseif ($this->juryPageState == self::$JuryPageStateEditExhibition) { return "JuryPageStateEditExhibition"; }
    elseif ($this->juryPageState == self::$JuryPageStateLiveResultPage) { return "JuryPageStateLiveResultPage"; }
    return null;
  }

  public function getExpoPageState()
  {
    if ($this->expoPageState == self::$ExpoPageStateHomePage) { return "ExpoPageStateHomePage"; }
    elseif ($this->expoPageState == self::$ExpoPageStateMyExhibitionPage) { return "ExpoPageStateMyExhibitionPage"; }
    elseif ($this->expoPageState == self::$ExpoPageStateExhibitionPage) { return "ExpoPageStateExhibitionPage"; }
    elseif ($this->expoPageState == self::$ExpoPageStateEditExhibition) { return "ExpoPageStateEditExhibition"; }
    elseif ($this->expoPageState == self::$ExpoPageStateVoteDetailsPage) { return "ExpoPageStateVoteDetailsPage"; }
    elseif ($this->expoPageState == self::$ExpoPageStateDatabase) { return "ExpoPageStateDatabase"; }
    elseif ($this->expoPageState == self::$ExpoPageStateLiveResultPage) { return "ExpoPageStateLiveResultPage"; }
    return null;
  }

  public function getSpectatorPageState()
  {
    if ($this->spectatorPageState == self::$SpectatorPageStateHomePage) { return "SpectatorPageStateHomePage"; }
    elseif ($this->spectatorPageState == self::$SpectatorPageStateExhibitionPage) { return "SpectatorPageStateExhibitionPage"; }
    elseif ($this->spectatorPageState == self::$SpectatorPageStateVoteDetailsPage) { return "SpectatorPageStateVoteDetailsPage"; }
    elseif ($this->spectatorPageState == self::$SpectatorPageStateDatabase) { return "SpectatorPageStateDatabase"; }
    elseif ($this->spectatorPageState == self::$SpectatorPageStateLiveResultPage) { return "SpectatorPageStateLiveResultPage"; }
    return null;
  }

  public function correctLogin()
  {
    $wasEventProcessed = false;
    
    $aLoginState = $this->loginState;
    if ($aLoginState == self::$LoginStateOnLoginScreen)
    {
      $this->setLoginState(self::$LoginStateLoggedIn);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function incorrectLoginInformation()
  {
    $wasEventProcessed = false;
    
    $aLoginState = $this->loginState;
    if ($aLoginState == self::$LoginStateOnLoginScreen)
    {
      $this->setLoginState(self::$LoginStateIncorrectLogin);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function displayHomePage()
  {
    $wasEventProcessed = false;
    
    $aLoginState = $this->loginState;
    if ($aLoginState == self::$LoginStateLoggedIn)
    {
      $this->setLoginState(self::$LoginStateHomePage);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function displayError()
  {
    $wasEventProcessed = false;
    
    $aLoginState = $this->loginState;
    if ($aLoginState == self::$LoginStateIncorrectLogin)
    {
      $this->setLoginState(self::$LoginStateOnLoginScreen);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function selectsExhibiton()
  {
    $wasEventProcessed = false;
    
    $aJuryPageState = $this->juryPageState;
    $aExpoPageState = $this->expoPageState;
    $aSpectatorPageState = $this->spectatorPageState;
    if ($aJuryPageState == self::$JuryPageStateHomePage)
    {
      $this->setJuryPageState(self::$JuryPageStateExhibitionPage);
      $wasEventProcessed = true;
    }

    
    if ($aExpoPageState == self::$ExpoPageStateHomePage)
    {
      $this->setExpoPageState(self::$ExpoPageStateExhibitionPage);
      $wasEventProcessed = true;
    }

    
    if ($aSpectatorPageState == self::$SpectatorPageStateHomePage)
    {
      $this->setSpectatorPageState(self::$SpectatorPageStateExhibitionPage);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function selectsAdmin()
  {
    $wasEventProcessed = false;
    
    $aJuryPageState = $this->juryPageState;
    if ($aJuryPageState == self::$JuryPageStateHomePage)
    {
      $this->setJuryPageState(self::$JuryPageStateAdmin);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function selectsLiveResult()
  {
    $wasEventProcessed = false;
    
    $aJuryPageState = $this->juryPageState;
    $aExpoPageState = $this->expoPageState;
    $aSpectatorPageState = $this->spectatorPageState;
    if ($aJuryPageState == self::$JuryPageStateHomePage)
    {
      $this->setJuryPageState(self::$JuryPageStateLiveResultPage);
      $wasEventProcessed = true;
    }

    
    if ($aExpoPageState == self::$ExpoPageStateHomePage)
    {
      $this->setExpoPageState(self::$ExpoPageStateLiveResultPage);
      $wasEventProcessed = true;
    }

    
    if ($aSpectatorPageState == self::$SpectatorPageStateHomePage)
    {
      $this->setSpectatorPageState(self::$SpectatorPageStateLiveResultPage);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function editExhibitionTeam()
  {
    $wasEventProcessed = false;
    
    $aJuryPageState = $this->juryPageState;
    if ($aJuryPageState == self::$JuryPageStateAdmin)
    {
      $this->setJuryPageState(self::$JuryPageStateEditExhibition);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function addTeamMember()
  {
    $wasEventProcessed = false;
    
    $aJuryPageState = $this->juryPageState;
    $aExpoPageState = $this->expoPageState;
    if ($aJuryPageState == self::$JuryPageStateEditExhibition)
    {
      $this->setJuryPageState(self::$JuryPageStateEditExhibition);
      $wasEventProcessed = true;
    }

    
    if ($aExpoPageState == self::$ExpoPageStateEditExhibition)
    {
      $this->setExpoPageState(self::$ExpoPageStateEditExhibition);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function changeExhibitionDetails()
  {
    $wasEventProcessed = false;
    
    $aJuryPageState = $this->juryPageState;
    $aExpoPageState = $this->expoPageState;
    if ($aJuryPageState == self::$JuryPageStateEditExhibition)
    {
      $this->setJuryPageState(self::$JuryPageStateEditExhibition);
      $wasEventProcessed = true;
    }

    
    if ($aExpoPageState == self::$ExpoPageStateEditExhibition)
    {
      $this->setExpoPageState(self::$ExpoPageStateEditExhibition);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function editMyExhibition()
  {
    $wasEventProcessed = false;
    
    $aExpoPageState = $this->expoPageState;
    if ($aExpoPageState == self::$ExpoPageStateHomePage)
    {
      $this->setExpoPageState(self::$ExpoPageStateMyExhibitionPage);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function edit()
  {
    $wasEventProcessed = false;
    
    $aExpoPageState = $this->expoPageState;
    if ($aExpoPageState == self::$ExpoPageStateMyExhibitionPage)
    {
      $this->setExpoPageState(self::$ExpoPageStateEditExhibition);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function sendVote()
  {
    $wasEventProcessed = false;
    
    $aExpoPageState = $this->expoPageState;
    $aSpectatorPageState = $this->spectatorPageState;
    if ($aExpoPageState == self::$ExpoPageStateExhibitionPage)
    {
      $this->setExpoPageState(self::$ExpoPageStateVoteDetailsPage);
      $wasEventProcessed = true;
    }
    elseif ($aExpoPageState == self::$ExpoPageStateVoteDetailsPage)
    {
      $this->setExpoPageState(self::$ExpoPageStateDatabase);
      $wasEventProcessed = true;
    }

    
    if ($aSpectatorPageState == self::$SpectatorPageStateExhibitionPage)
    {
      $this->setSpectatorPageState(self::$SpectatorPageStateVoteDetailsPage);
      $wasEventProcessed = true;
    }
    elseif ($aSpectatorPageState == self::$SpectatorPageStateVoteDetailsPage)
    {
      $this->setSpectatorPageState(self::$SpectatorPageStateDatabase);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function newVote()
  {
    $wasEventProcessed = false;
    
    $aExpoPageState = $this->expoPageState;
    $aSpectatorPageState = $this->spectatorPageState;
    if ($aExpoPageState == self::$ExpoPageStateDatabase)
    {
      $this->setExpoPageState(self::$ExpoPageStateExhibitionPage);
      $wasEventProcessed = true;
    }

    
    if ($aSpectatorPageState == self::$SpectatorPageStateDatabase)
    {
      $this->setSpectatorPageState(self::$SpectatorPageStateExhibitionPage);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function replaceOldVote()
  {
    $wasEventProcessed = false;
    
    $aExpoPageState = $this->expoPageState;
    $aSpectatorPageState = $this->spectatorPageState;
    if ($aExpoPageState == self::$ExpoPageStateDatabase)
    {
      $this->setExpoPageState(self::$ExpoPageStateExhibitionPage);
      $wasEventProcessed = true;
    }

    
    if ($aSpectatorPageState == self::$SpectatorPageStateDatabase)
    {
      $this->setSpectatorPageState(self::$SpectatorPageStateExhibitionPage);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function setLoginState($aLoginState)
  {
    $this->loginState = $aLoginState;
  }

  private function setJuryPageState($aJuryPageState)
  {
    $this->juryPageState = $aJuryPageState;
  }

  private function setExpoPageState($aExpoPageState)
  {
    $this->expoPageState = $aExpoPageState;
  }

  private function setSpectatorPageState($aSpectatorPageState)
  {
    $this->spectatorPageState = $aSpectatorPageState;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>