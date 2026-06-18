class Solution {
    public double angleClock(int hour, int minutes) {
       // taking reference from 12
       // working with degree

       //For minutes
       // 360(angle)/60(minutes) = 6 (per minute)
       double min_angle=6*minutes;

       //For hours
       // 360(angle)/12(hours in clock) = 30 (per hour)
       double hour_angle=(30*(hour%12));

       // as mintues moves hour hand moves slowly slowly (eg- from 12->1 or 3->4)
       // from (12->1) we have 30 angle so 30/60(mintues) = 0.5
       // hour hand moves 0.5 per mintue
       hour_angle+=(minutes)*0.5;

       double diff= Math.abs(hour_angle-min_angle);
       return Math.min(diff,360-diff);
    }
}
