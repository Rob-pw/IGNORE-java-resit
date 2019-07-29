import java.util.Objects;

public
 class CliRouteAdd
 implements
    CliShow
  , CliProvidesChoice<CliShow>
{ public
   Choice<CliShow> getCliChoice()
  { return
     new Choice<CliShow>
      ( (CliShow)this
      , "a"
      , "add a route"); }

  public
   CliValidity isChoiceValid
    ( Application app)
  { return CliValidity.valid(); }

  public
   void show
    ( Application app)
  { String routeEntry
     = CliSelector.askFor
        ( "route path (like: "
          + "Aberystwyth:AB1:BB1:Borth")
  ; RouteParser routeParser
     = new RouteParser(app)

  ; Route parsed
     = routeParser.parse(routeEntry)
  ; if (Objects.isNull(parsed))
    { return; }

  ; String name
     = CliSelector.askFor
        ("name")

  ; parsed.setName(name)
  ; app.routes.add(parsed); } }
