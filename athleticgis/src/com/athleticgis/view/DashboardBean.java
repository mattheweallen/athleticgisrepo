package com.athleticgis.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;

import com.athleticgis.domain.activity.Activity;
import com.athleticgis.model.AthleticgisFacade;
import com.athleticgis.view.model.ActivityDataModel;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class DashboardBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//List<Activity> activities;
	LazyDataModel<Activity> lazyModel;
	Activity selectedActivity;
	@ManagedProperty(value = "#{userInfoBean}")
    private UserInfoBean userInfoBean;
	
	public UserInfoBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(UserInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}
	
	/**
	 * @return the selectedActivity
	 */
	public Activity getSelectedActivity() {
		return selectedActivity;
	}

	/**
	 * @param selectedActivity the selectedActivity to set
	 */
	public void setSelectedActivity(Activity selectedActivity) {
		this.selectedActivity = selectedActivity;
	}
	
	/**
	 * @return the lazyModel
	 */
	public LazyDataModel<Activity> getLazyModel() {
		if (lazyModel == null) {
			lazyModel = new ActivityDataModel(userInfoBean.getUser_id(), userInfoBean.getIsAdmin());
		}
		return lazyModel;
		//return new ActivityDataModel(userInfoBean.getUser_id());
	}

//	public List<Activity> getActivities() {
//		//return activityModel.getActivities();
//		//AthleticgisFacade athleticgisFacade = new AthleticgisFacade();
//		//hard coded user_id use UserInfo
//		//fix, show all for admin, show particular for non admin
//		
//		//attempt at lazy loading
//		//if(activities == null || activities.size() == 0) {
//			if(!userInfoBean.getIsAdmin()) {
//				activities = AthleticgisFacade.findActivitiesByUserId(userInfoBean.getUser_id());
//			} else {
//				activities = AthleticgisFacade.findAllActivities();
//			}
//		//}
//		return activities;
//	}
	
	
//	public void fileUploadListener(FileUploadEvent event) throws Exception {
//		UploadedFile item = event.getUploadedFile();
//	    File file = new File();
//	    file.setLength(item.getData().length);
//	    file.setName(item.getName());
//	    file.setData(item.getData());
//	    files.add(file);
//	    uploadsAvailable--;
//	}
//	public void setActivityName(List<Activity> activities) {
//		this.activities = activities;
//	}
}
