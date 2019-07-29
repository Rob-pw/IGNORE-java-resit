public
 class CliUserMenu
 implements
    CliShow
  , CliProvidesChoice<CliShow>
{ public
   Choice<CliShow> getCliChoice()
  { return
     new Choice<CliShow>
      ( (CliShow)this
      , "u"
      , "display user options"); }

  public
   CliValidity isChoiceValid
    ( Application app)
  { return CliValidity.valid(); }

  public
   void show
    ( Application app)
  { CliSelector selector
     = CliSelector.createFrom
        ( new CliRouteAdd()
        , new CliRouteDelete()
        , new CliRouteDisplay())

  ; while(selector.engage(app)); } }
