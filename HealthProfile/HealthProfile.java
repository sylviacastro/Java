public class HealthProfile
{
   //instance variable declaration
   private String name;
   private int age;
   private int weight;
   private int height;
   
    public HealthProfile()
    {
        this.name = "";
        this.age = 0;
        this.weight = 0;
        this.height = 0;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String aName)
    {
        if(aName != "")
        {
            this.name = aName;
        }
        else
        {
            this.name = "";
        }
    }
    public int getAge()

    {
        return this.age;
    }

    public void setAge(int aAge)
    {
        if (aAge > 0)
        {
            this.age = aAge;
        }
        else
        {
            this.age = 0;
        }
    }
    
    public int getWeight()
    {
        return this.weight;
    }
    
    public void setWeight(int aWeight)
    {
        if (aWeight > 0)
        {
            this.weight = aWeight;
        }
        else
        {
            this.weight = 0;
        }  
    }
    
    public int getHeight()
    {
        return this.height;
    }
    
    public void setHeight(int feet, int inches)
    {
        if (feet > 0 && inches >= 0 && inches < 12)
        {
            this.height = feet * 12 + inches;
        }
        else
        {
            this.height = 0;
        }  
    }        
    
    public double getBMI()
    {
        String num = String.format("%.1f", 
        getWeight() * 703 / Math.pow(getHeight(), 2.0));
        
        return Double.parseDouble(num);
    }
    
    public String getCategory()
    {
        double bmi = getBMI();
        
        if (bmi < 18.5)
        {
            return "Underweight";
        }
        if (bmi >= 18.5 && bmi <= 24.9)
        {
            return "Normal";
        }
        if (bmi >= 25 && bmi <= 29.9)
        {
            return "Overweight";
        }
        if (bmi >30)
        {
            return "Obese";
        }
        return "";
    }  
    
    public int getMaxHR()
    {
        return 200 - getAge();
    }
}

