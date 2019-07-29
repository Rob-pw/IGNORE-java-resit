public
 class CliValidity
{ private
   boolean isValid = true
; private
   String validityMessage = null;

  private
   CliValidity
    ( Boolean isValid)
  { this.isValid = isValid; }

  private
   CliValidity
    ( Boolean isValid
    , String validityMessage)
  { this.isValid = isValid
  ; this.validityMessage = validityMessage; }

  public
   boolean isValid()
  { return this.isValid; }

  public
   String validityMessage()
  { return this.validityMessage; }

  public static
   CliValidity notValid
    ( String validityMessage)
  { return
      new CliValidity
       (false, validityMessage); }

  public static
   CliValidity valid()
  { return
      new CliValidity
       (true); } }
