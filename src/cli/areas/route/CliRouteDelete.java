public
 class CliRouteDelete
 implements
    CliShow
  , CliProvidesChoice<CliShow>
{ public
   Choice<CliShow> getCliChoice()
  { return
     new Choice<CliShow>
      ( (CliShow)this
      , "d"
      , "delete a route"); }

  public
   CliValidity isChoiceValid
    ( Application app)
  { return CliValidity.valid(); }

  public
   void show
    ( Application app)
  { CliSelector.say
     ( "Deleting a route")
  ; CliChoiceDialog choiceDialog
     = new CliChoiceDialog<Route>()

  ; Route[] newArray
     = new Route
       [app.routes.size()]
  ; Route[] routesArray
     = app.routes.toArray(newArray)

  ; Route chosenRoute
     = (Route)choiceDialog
        . makeNumberedPassingChoice
           ( routesArray)

  ; app.routes.remove(chosenRoute); } }
