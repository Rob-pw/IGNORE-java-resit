public
 class CliAdminMenu
 implements
    CliShow
  , CliProvidesChoice<CliShow>
{ public
   CliValidity isChoiceValid
    ( Application app)
  { return CliValidity.valid(); }

  public
   Choice<CliShow> getCliChoice()
  { return
      new Choice<CliShow>
       ( (CliShow)this
       , "a"
       , "proceed as admin user"); }

  public
   void show
    ( Application app)
  { Boolean result
     = CliAdminMenu.showOptions(app)
  ; while(result)
      this.show(app); }

  private
   Boolean showOptions
    ( Application app)
  { CliSelector selector
     = CliSelector.createFrom
        ( new CliSettlementCreateMenu()
        , new CliRoadSegments()
        , new CliRoad())

  ; return selector.engage(app); } }
