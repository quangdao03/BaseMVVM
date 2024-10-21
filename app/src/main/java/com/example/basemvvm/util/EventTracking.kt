package com.example.basemvvm.util

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
object EventTracking {

    const val EVENT_NAME_SPLASH_OPEN = "splash_open"
    const val EVENT_NAME_LANGUAGE_FO_OPEN ="language_fo_open"
    const val EVENT_NAME_LANGUAGE_FO_SAVE_CLICK  = "language_fo_save_click"
    const val EVENT_NAME_ONBOARDING1_NEXT_VIEW = "Onboarding1_next_view"
    const val EVENT_NAME_ONBOARDING1_NEXT_CLICK = "onboarding1_next_click"
    const val EVENT_NAME_ONBOARDING2_NEXT_VIEW = "Onboarding2_next_view"
    const val EVENT_NAME_ONBOARDING2_NEXT_CLICK = "onboarding2_next_click"
    const val EVENT_NAME_ONBOARDING3_NEXT_VIEW = "Onboarding3_next_view"
    const val EVENT_NAME_ONBOARDING3_NEXT_CLICK = "onboarding3_next_click"
    const val EVENT_NAME_PERMISSION_OPEN ="permisson open"
    const val EVENT_NAME_PERMISSION_CLICK = "permission_click"
    const val EVENT_NAME_PERMISSION_CONTINUE_CLICK = "permission_continue_click"
    const val EVENT_NAME_RATE_SHOW = "rate_show"
    const val EVENT_NAME_RATE_EXIT_CHOOSE = "rate_exit_choose"
    const val EVENT_NAME_RATE_CHOOSE = "rate_choose"
    const val EVENT_NAME_HOME_VIEW ="home_view"
    const val EVENT_NAME_HOME_TEMPLATE_LOGO_CHOOSE ="home_template_logo_choose"
    const val EVENT_NAME_HOME_TEMPLATE_INSTAGRAM_STORY_CHOOSE ="home_template_instagram_story_choose"
    const val EVENT_NAME_HOME_TEMPLATE_INSTAGRAM_POST_CHOOSE ="home_template_instagram_post_choose"
    const val EVENT_NAME_HOME_TEMPLATE_BUSINESS_CARD_CHOOSE ="home_template_business_card_choose"
    const val EVENT_NAME_HOME_TEMPLATE_FLYER_CHOOSE ="home_template_flyer_choose"
    const val EVENT_NAME_HOME_TEMPLATE_INVITATION_CHOOSE ="home_template_invitation_choose"
    const val EVENT_NAME_HOME_VIEW_MORE_CLICK ="home_view_more_click"
    const val EVENT_NAME_HOME_ITEM_CHOOSE ="home_item_choose"
    const val EVENT_NAME_ELEMENT_VIEW ="element_view"
    const val EVENT_NAME_ELEMENT_VIEW_ICON ="element_view_icon"
    const val EVENT_NAME_ELEMENT_VIEW_SHAPE ="element_view_shape"
    const val EVENT_NAME_ELEMENT_VIEW_LOGO ="element_view_logo"
    const val EVENT_NAME_ELEMENT_ITEM_CHOOSE ="element_item_choose"
    const val EVENT_NAME_CREATE_VIEW ="create_view"
    const val EVENT_NAME_CREATE_TEMPLATE_CHOOSE ="create_template_choose"
    const val EVENT_NAME_CREATE_BACKGROUND_TEMPLATE_CHOOSE ="create_background_template_choose"
    const val EVENT_NAME_CREATE_BACKGROUND_CLICK ="create_background_click"
    const val EVENT_NAME_CREATE_BACKGROUND_IMPORT_CHOOSE ="create_background_import_choose"
    const val EVENT_NAME_CREATE_BACKGROUND_COLOR_CHOOSE ="create_background_color_choose"
    const val EVENT_NAME_CREATE_BACKGROUND_GRADIENT_CHOOSE ="create_background_gradient_choose"
    const val EVENT_NAME_CREATE_BACKGROUND_GRADIENT_ANGLE_CHOOSE ="create_background_gradient_angle_choose"
    const val EVENT_NAME_CREATE_TEXT_CHOOSE ="create_text_choose"
    const val EVENT_NAME_CREATE_FONT_TEXT_CHOOSE ="create_font_text_choose"
    const val EVENT_NAME_CREATE_SIZE_TEXT_CHOOSE ="create_size_text_choose"
    const val EVENT_NAME_CREATE_COLOR_TEXT_CHOOSE ="create_color_text_choose"
    const val EVENT_NAME_CREATE_ARC_TEXT_CHOOSE = "create_arc_text_choose"
    const val EVENT_NAME_CREATE_STYLE_TEXT_CHOOSE = "create_style_text_choose"
    const val EVENT_NAME_CREATE_STROKE_TEXT_CHOOSE = "create_stroke_text_choose"
    const val EVENT_NAME_CREATE_ALIGN_TEXT_CHOOSE = "create_align_text_choose"
    const val EVENT_NAME_CREATE_SHADOW_TEXT_CHOOSE = "create_shadow_text_choose"
    const val EVENT_NAME_CREATE_SHADOW_TEXT_ANGLE_CHOOSE = "create_shadow_text_angle_choose"
    const val EVENT_NAME_CREATE_SHADOW_TEXT_BLUR_CHOOSE ="create_shadow_text_blur_choose"
    const val EVENT_NAME_CREATE_SHADOW_TEXT_COLOR_CHOOSE ="create_shadow_text_color_choose"
    const val EVENT_NAME_CREATE_SHADOW_TEXT_OPACITY_CHOOSE ="create_shadow_text_opacity_choose"
    const val EVENT_NAME_CREATE_OPACITY_TEXT_CHOOSE ="create_opacity_text_choose"
    const val EVENT_NAME_CREATE_ROTATION_TEXT_CHOOSE ="create_rotation_text_choose"
    const val EVENT_NAME_CREATE_SPACING_TEXT_CHOOSE ="create_spacing_text_choose"
    const val EVENT_NAME_CREATE_DRAW_CHOOSE ="create_draw_choose"
    const val EVENT_NAME_CREATE_SIZE_DRAW_CHOOSE ="create_size_draw_choose"
    const val EVENT_NAME_CREATE_OVERLAY_DRAW_CHOOSE = "create_overlay_draw_choose"
    const val EVENT_NAME_CREATE_COLOR_DRAW_CHOOSE = "create_color_draw_choose"
    const val EVENT_NAME_CREATE_OPACITY_DRAW_CHOOSE = "create_opacity_draw_choose"
    const val EVENT_NAME_CREATE_ROTATION_DRAW_CHOOSE = "create_rotation_draw_choose"
    const val EVENT_NAME_CREATE_ICON_CHOOSE = "create_icon_choose"
    const val EVENT_NAME_CREATE_ICON_VIEW = "create_icon_view"
    const val EVENT_NAME_CREATE_SIZE_ICON_CHOOSE = "create_size_icon_choose"
    const val EVENT_NAME_CREATE_OVERLAY_ICON_CHOOSE = "create_overlay_icon_choose"
    const val EVENT_NAME_CREATE_COLOR_ICON_CHOOSE = "create_color_icon_choose"
    const val EVENT_NAME_CREATE_CROP_ICON_CHOOSE = "create_crop_icon_choose"
    const val EVENT_NAME_CREATE_OPACITY_ICON_CHOOSE = "create_opacity_icon_choose"
    const val EVENT_NAME_CREATE_ROTATION_ICON_CHOOSE = "create_rotation_icon_choose"
    const val EVENT_NAME_CREATE_SHAPE_CHOOSE = "create_shape_choose"
    const val EVENT_NAME_CREATE_SHAPE_VIEW = "create_shape_view"
    const val EVENT_NAME_CREATE_BORDER_SHAPE_CHOOSE = "create_border_shape_choose"
    const val EVENT_NAME_CREATE_BORDER_SHAPE_STYLE_CHOOSE = "create_border_shape_style_choose"
    const val EVENT_NAME_CREATE_BORDER_SHAPE_SIZE_CHOOSE =  "create_border_shape_size_choose"
    const val EVENT_NAME_CREATE_BORDER_SHAPE_COLOR_CHOOSE = "create_border_shape_color_choose"
    const val EVENT_NAME_CREATE_SIZE_SHAPE_CHOOSE = "create_size_shape_choose"
    const val EVENT_NAME_CREATE_COLOR_SHAPE_CHOOSE = "create_color_shape_choose"
    const val EVENT_NAME_CREATE_SHADOW_SHAPE_CHOOSE = "create_shadow_shape_choose"
    const val EVENT_NAME_CREATE_SHADOW_SHAPE_ANGLE_CHOOSE ="create_shadow_shape_angle_choose"
    const val EVENT_NAME_CREATE_SHADOW_SHAPE_BLUR_CHOOSE = "create_shadow_shape_blur_choose"
    const val EVENT_NAME_CREATE_SHADOW_SHAPE_COLOR_CHOOSE = "create_shadow_shape_color_choose"
    const val EVENT_NAME_CREATE_SHADOW_SHAPE_OPACITY_CHOOSE = "create_shadow_shape_opacity_choose"
    const val EVENT_NAME_CREATE_OPACITY_SHAPE_CHOOSE = "create_opacity_shape_choose"
    const val EVENT_NAME_CREATE_ROTATION_SHAPE_CHOOSE = "create_rotation_shape_choose"
    const val EVENT_NAME_CREATE_LOGO_CHOOSE ="create_logo_choose"
    const val EVENT_NAME_CREATE_LOGO_VIEW ="create_logo_view"
    const val EVENT_NAME_CREATE_SIZE_LOGO_CHOOSE ="create_size_logo_choose"
    const val EVENT_NAME_CREATE_OVERLAY_LOGO_CHOOSE ="create_overlay_logo_choose"
    const val EVENT_NAME_CREATE_COLOR_LOGO_CHOOSE ="create_color_logo_choose"
    const val EVENT_NAME_CREATE_CROP_LOGO_CHOOSE ="create_crop_logo_choose"
    const val EVENT_NAME_CREATE_OPACITY_LOGO_CHOOSE ="create_opacity_logo_choose"
    const val EVENT_NAME_CREATE_ROTATION_LOGO_CHOOSE ="create_rotation_logo_choose"
    const val EVENT_NAME_MY_PROJECT_VIEW ="my_project_view"
    const val EVENT_NAME_MY_PROJECT_DRAFT_CHOOSE ="my_project_draft_choose"
    const val EVENT_NAME_MY_PROJECT_COMPLETE_CHOOSE ="my_project_complete_choose"
    const val EVENT_NAME_MY_PROJECT_CREATE_CHOOSE ="my_project_create_choose"
    const val EVENT_NAME_FAVOURITE_VIEW ="favorite_view"
    const val EVENT_NAME_FAVOURITE_LOGO_CHOOSE ="favorite_logo_choose"
    const val EVENT_NAME_FAVOURITE_INSTAGRAM_STORY_CHOOSE ="favorite_instagram_story_choose"
    const val EVENT_NAME_FAVOURITE_BUSINESS_CARD_CHOOSE ="favorite_business_card_choose"
    const val EVENT_NAME_FAVOURITE_FLYER_CHOOSE ="favorite_flyer_choose"
    const val EVENT_NAME_FAVOURITE_INVITATION_CHOOSE ="favorite_invitation_choose"
    const val EVENT_NAME_SETTING_VIEW ="setting_view"
    const val EVENT_NAME_SETTING_LANGUAGE_CLICK ="setting_language_click"
    const val EVENT_NAME_SETTING_RATE_CLICK ="setting_rate_click"
    const val EVENT_NAME_SETTING_PRIVACY_POLICY_CLICK ="setting_privacy_policy_click"
    const val EVENT_NAME_SETTING_SHARE_CLICK ="setting_share_click"

    fun logEvent(context: Context, nameEvent: String) {
        val bundle = Bundle()
        FirebaseAnalytics.getInstance(context).logEvent(nameEvent, bundle)
    }

    fun logEvent(context: Context, nameEvent: String, param: String, value: String) {
        val bundle = Bundle()
        bundle.putString(param, value)
        FirebaseAnalytics.getInstance(context).logEvent(nameEvent, bundle)
    }

    fun logEvent(context: Context, nameEvent: String, param: String, value: Long) {
        val bundle = Bundle()
        bundle.putLong(param, value)
        FirebaseAnalytics.getInstance(context).logEvent(nameEvent, bundle)
    }

}