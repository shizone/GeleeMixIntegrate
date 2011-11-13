package jp.gr.java_conf.razon.geleeMixIntegrate;

import hudson.Extension;
import hudson.model.Hudson;
import hudson.model.Action;
import hudson.model.RootAction;
import hudson.security.AccessControlled;
import hudson.security.Permission;
import org.jvnet.localizer.ResourceBundleHolder;

/**
 * GeleeMixIntegratePluginのRootAction
 * @author razon
 */

@Extension
public class GeleeMixIntegrateRootAction implements RootAction ,Action {

    private final Hudson hudson;

    public GeleeMixIntegrateRootAction() {
        hudson = Hudson.getInstance();
    }

    public final String getDisplayName() {
        return Messages.displayName();
    }

    public final String getUrlName() {
        return "/" + GeleeMixIntegrateConsts.BASE_URL;
    }

    public final String getIconFileName() {
        return hasConfigurePermission() ? GeleeMixIntegrateConsts.ICON_PATH : null;
    }

    protected AccessControlled getAccessControlledObject() {
        return this.hudson;
    }
    
    protected boolean hasConfigurePermission() {
        return getAccessControlledObject().hasPermission(Permission.CONFIGURE);
    }

}
