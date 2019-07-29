public
 class CliEntryPoint
{ public
   void initCli()
  { Application app
     = new Application()

  ; CliSelector cliSelector
     = CliSelector.createFrom
        ( new CliUserMenu()
        , new CliAdminMenu()
        , new CliPersistance())
  ; cliSelector.setTopLevel()

  ; while(cliSelector.engage(app))
  ; itsTimeToSayGoodbye(); }

  private
   void itsTimeToSayGoodbye()
  { String whois
     = System.getProperty("user.name")
  ; String properCapitalsWhois
     = whois.substring(0, 1).toUpperCase()
        + whois.substring(1)

  ; System.out.println
     ( String.format
        ( "Farewell, %s!"
        , properCapitalsWhois)); } }