package cs4521.project.sensorsforbikers;

import android.location.Location;

public class CLocation extends Location
{
  private boolean bUseMetricUnits = false;

  public CLocation(Location location)
  {
    this(location, true);
  }

  public CLocation(Location location, boolean bUseMetricUnits)
  {
    super(location);
    this.bUseMetricUnits = bUseMetricUnits;
  }

  public boolean getUseMetricUnits()
  {
    return this.bUseMetricUnits;
  }

  public void setUseMetricUnits(boolean bUseMetricUnits)
  {
    this.bUseMetricUnits = bUseMetricUnits;
  }

  @Override
  public float distanceTo(Location dest)
  {
    float nDistance = super.distanceTo(dest);

    if (!this.getUseMetricUnits())
    {
      // Convert meters to feet
      nDistance = nDistance * 3.28083989501312f;
    }

    return nDistance;
  }

  @Override
  public float getAccuracy()
  {
    float nAccuracy = super.getAccuracy();

    if (!this.getUseMetricUnits())
    {
      // Convert meters to feet
      nAccuracy = nAccuracy * 3.28083989501312f;
    }

    return nAccuracy;
  }

  @Override
  public double getAltitude()
  {
    double nAltitude = super.getAltitude();

    if (!this.getUseMetricUnits())
    {
      // Convert meters to feet
      nAltitude = nAltitude * 3.28083989501312d;
    }

    return nAltitude;
  }

  @Override
  public float getSpeed()
  {
    float nSpeed = super.getSpeed();
    nSpeed = nSpeed * 3.6f;
    
    if (!this.getUseMetricUnits())
    {
      // Convert meters/second to miles/hour
      nSpeed = nSpeed * 0.621371f;
    }

    return nSpeed;
  }
}