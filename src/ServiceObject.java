import java.util.ArrayList;

public class ServiceObject implements ServiceInterface
{
  public ArrayList<Integer> getAuthorizedIds()
  {
    ArrayList<Integer> authorizedIds = new ArrayList<>();

    //Fetch authorized ID's
    //DUMMY DATA: Only clientId's that are prime numbers between 7 and 23 can be authorized:
    authorizedIds.add(7);
    authorizedIds.add(11);
    authorizedIds.add(13);
    authorizedIds.add(17);
    authorizedIds.add(19);
    authorizedIds.add(23);
    authorizedIds.add(29);

    return authorizedIds;
  }

  public ArrayList<String> getAuthorizedCountries()
  {
    ArrayList<String> authorizedCountries = new ArrayList<>();

    //Fetch the authorized countries:
    //DUMMY DATA: Only clients from Denmark have access to the citizenship information:
    authorizedCountries.add("Denmark");
    authorizedCountries.add("DK");
    authorizedCountries.add("DNK");

    return authorizedCountries;
  }



  @Override public ArrayList<ArrayList<String>> getCitizenshipData(Client client)
  {
    //Query another source for the citizenship data.
    //Perform a heavy cost task
    int counter = 0;

    //Build the citizenship data to send
    ArrayList<ArrayList<String>> citizenshipData = new ArrayList<>();

    //Dummy Data: Possible citizenshipStatus:
    ArrayList<String> possibleCitizenshipStatus = new ArrayList<>();
    possibleCitizenshipStatus.add("Citizen");
    possibleCitizenshipStatus.add("Asylum Seeker");
    possibleCitizenshipStatus.add("Temporary Refugee");
    possibleCitizenshipStatus.add("Legal Resident");

    //Dummy Data: Possible criminal status:
    ArrayList<String> possibleCriminalStatus = new ArrayList<>();
    possibleCriminalStatus.add("No Criminal History");
    possibleCriminalStatus.add("Minor Traffic violations");
    possibleCriminalStatus.add("Major Traffic violations");
    possibleCriminalStatus.add("Criminal Fraud");
    possibleCriminalStatus.add("Involuntary Man-slaughter");
    possibleCriminalStatus.add("Man-slaughter");
    possibleCriminalStatus.add("Mass Murder");
    possibleCriminalStatus.add("Terrorism");

    while(counter <= 1000000)
    {
      ArrayList<String> specificCitizenData = new ArrayList<>();

      //1st Query citizen name:
      if(counter < 10)
      {
        specificCitizenData.add("Citizen #000000" + counter);
      }
      if(counter < 100 && counter >= 10)
      {
        specificCitizenData.add("Citizen #00000" + counter);
      }
      if(counter < 1000 && counter >= 100)
      {
        specificCitizenData.add("Citizen #0000" + counter);
      }
      if(counter < 10000 && counter >= 1000)
      {
        specificCitizenData.add("Citizen #000" + counter);
      }
      if(counter < 100000 && counter >= 10000)
      {
        specificCitizenData.add("Citizen #00" + counter);
      }
      if(counter < 1000000 && counter >= 100000)
      {
        specificCitizenData.add("Citizen #0" + counter);
      }
      if(counter >= 1000000)
      {
        specificCitizenData.add("Citizen #" + counter);
      }

      //2nd Query citizenshipStatus:
      if(counter%2 == 0)
      {
        //Ensure 50% of population are full citizens.
        specificCitizenData.add(possibleCitizenshipStatus.get(0));
      }
      if(counter%2 != 0)
      {
        //Assign a mixture of citizenship status' to the remaining 50% of the population.
        specificCitizenData.add(possibleCitizenshipStatus.get(((int) (Math.random()*100))%3));
      }


      //3rd Query Criminal Status:
      ArrayList<String> possibleTimeSentences = new ArrayList<>();
      for (int i = 0; i < 50; i++)
      {
        if(i == 0)
        {
          possibleTimeSentences.add("Punished with a fine.");
        }
        else
        {
          possibleTimeSentences.add("Punished with " + i + " years in jail.");
        }
      }

      if(counter%2 == 0)
      {
        //Ensure 50% of population are full citizens.
        specificCitizenData.add(possibleCriminalStatus.get(0));
      }
      if(counter%2 != 0)
      {
        //Assign a mixture of citizenship status' to the remaining 50% of the population.
        specificCitizenData.add(possibleCriminalStatus.get(((int) (Math.random()*100))%7));
        if(specificCitizenData.get(2).equalsIgnoreCase("No Criminal History") || specificCitizenData.get(2).equalsIgnoreCase("Minor Traffic violations"))
        {
          specificCitizenData.add(possibleTimeSentences.get((1 + (int) (Math.random()*100))%50));
        }
      }

      //Assign this citizen to the citizenshipData:
      citizenshipData.add(specificCitizenData);
      counter++;
    }
    return citizenshipData;
  }
}
