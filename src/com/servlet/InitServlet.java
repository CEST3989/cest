package com.servlet;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.util.Config;




/**
 * InitServlet to start services.
 */
/**
 * @author Rajesh Sao
 *
 */
public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 447574547124324L;
	
	
	private final static long ONCE_PER_DAY = 1000*60*60*24;
	private final static long ONCE_PER_WEEK = 1000*60*60*24*7;
	
	private static final String isSolrScheduler = Config.getConfig().getString("solr.scheduler.enable");
	private static int monitoringSchedularInterval = 300; //secs
	private static int removingSchedularInterval = 86400; //secs 
	
	static{
		if(StringUtils.isNotBlank(Config.getConfig().getString("solr.monitoring.scheduler.interval"))){
			monitoringSchedularInterval = Config.getConfig().getInt("solr.monitoring.scheduler.interval");
		}
		if(StringUtils.isNotBlank(Config.getConfig().getString("solr.removing.scheduler.interval"))){
			removingSchedularInterval = Config.getConfig().getInt("solr.removing.scheduler.interval");
		}
	}
	
	
	
	public void init(final ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext sContext = config.getServletContext();
        String delayInMilliSec = getServletConfig().getInitParameter("delayInMilliSec"); 
        
        String prefix =  getServletContext().getRealPath("/");
        String file = getInitParameter("log4j-init-file");
      

        try {
        	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sContext);
        	Config appConfig = Config.getConfig();
        	appConfig.setWebApplicationContext(wac);
       	}
        catch (Exception ex) {
            throw new ServletException("InitServlet Error during initialization", ex);
        }

    }

    public void destroy() {
    
    	
        super.destroy();
    }    
    
    
    /**
     * @param appConfig
     * @return
     */
    private static Date getDailyFirstTime(Config appConfig) {
		int dailyTimeHour = appConfig.getInt("csr.app.question.reminder.daily.time.hour");
		int dailyTimeMin = appConfig.getInt("csr.app.question.reminder.daily.time.min");

		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, dailyTimeHour);
		today.set(Calendar.MINUTE, dailyTimeMin);
		return today.getTime();
    }
    
    /**
     * @param appConfig
     * @return
     */
    private static Date getWeeklyFirstTime(Config appConfig) {
		int weeklyDay = appConfig.getInt("csr.app.question.reminder.weekly.day");
		int weeklyTimeHour = appConfig.getInt("csr.app.question.reminder.weekly.time.hour");
		int weeklyTimeMin = appConfig.getInt("csr.app.question.reminder.weekly.time.min");
		
		Calendar today = Calendar.getInstance();
		today.set(Calendar.DAY_OF_WEEK, weeklyDay);
		today.set(Calendar.HOUR_OF_DAY, weeklyTimeHour);
		today.set(Calendar.MINUTE, weeklyTimeMin);
		return today.getTime();
    }
}
