<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Activity.DashBoard_Activity"
    android:orientation="vertical" >

    <include
        layout="@layout/actionbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        />

    <!--<android.support.design.widget.AppBarLayout-->
        <!--android:layout_width="match_parent"-->
        <!--android:layout_height="80dp">-->

        <!--<android.support.v7.widget.Toolbar-->
            <!--android:id="@+id/ToolTip"-->
            <!--android:layout_width="match_parent"-->
            <!--android:layout_height="match_parent"-->
            <!--android:background="@color/colorPrimary">-->

            <!--<LinearLayout-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="match_parent"-->
                <!--android:orientation="horizontal"-->
                <!--android:weightSum="6">-->
                <!--<android.support.v7.widget.AppCompatImageView-->
                    <!--android:layout_width="50dp"-->
                    <!--android:layout_height="match_parent"-->
                    <!--android:layout_gravity="left|center_vertical"-->
                    <!--android:paddingTop="15dp"-->
                    <!--android:layout_weight="1.1"-->
                    <!--app:srcCompat="@drawable/watch" />-->
                <!--<LinearLayout-->
                    <!--android:layout_width="0dp"-->
                    <!--android:layout_height="match_parent"-->
                    <!--android:layout_weight="1.7">-->

                    <!--<android.support.v7.widget.AppCompatTextView-->
                        <!--android:layout_marginTop="20dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="match_parent"-->
                        <!--android:gravity="center_vertical|center"-->
                        <!--android:text="Thu,25 - Sep"-->
                        <!--android:textColor="@color/textColor"-->
                        <!--android:textSize="14dp"-->
                        <!--android:textStyle="bold" />-->

                <!--</LinearLayout>-->
                <!--<LinearLayout-->
                    <!--android:paddingTop="16dp"-->
                    <!--android:layout_width="0dp"-->
                    <!--android:layout_height="match_parent"-->
                    <!--android:layout_weight="1"-->
                    <!--android:orientation="vertical"-->
                    <!--android:weightSum="4">-->

                    <!--<android.support.v7.widget.AppCompatTextView-->
                        <!--android:layout_marginTop="12dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="0dp"-->
                        <!--android:layout_weight="1"-->
                        <!--android:gravity="center_vertical|center|bottom"-->
                        <!--android:text="Current"-->
                        <!--android:textColor="@color/textColor"-->
                        <!--android:textSize="10dp"-->
                        <!--android:textStyle="bold" />-->

                    <!--<android.support.v7.widget.AppCompatTextView-->
                        <!--android:id="@+id/tooltip1"-->
                        <!--android:layout_marginTop="2dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="0dp"-->
                        <!--android:layout_weight="1"-->
                        <!--android:gravity="center_vertical|center|bottom"-->
                        <!--android:text="123"-->
                        <!--android:textColor="@color/lineBlue"-->
                        <!--android:textSize="11dp" />-->

                    <!--<android.support.v7.widget.AppCompatTextView-->
                        <!--android:id="@+id/tooltip2"-->
                        <!--android:layout_marginTop="2dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="0dp"-->
                        <!--android:layout_weight="1"-->
                        <!--android:gravity="center_vertical|center|bottom"-->
                        <!--android:text="321"-->
                        <!--android:textColor="@color/textColor"-->
                        <!--android:textSize="9dp"/>-->

                    <!--<android.support.v7.widget.AppCompatTextView-->
                        <!--android:layout_marginTop="2dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="0dp"-->
                        <!--android:layout_weight="1"-->
                        <!--android:gravity="center_vertical|center|bottom"-->
                        <!--android:text="7dma"-->
                        <!--android:textColor="@color/textColor"-->
                        <!--android:textSize="9dp" />-->

                <!--</LinearLayout>-->
                <!--<LinearLayout-->
                    <!--android:paddingTop="16dp"-->
                    <!--android:layout_width="0dp"-->
                    <!--android:layout_height="match_parent"-->
                    <!--android:layout_weight="1"-->
                    <!--android:orientation="vertical"-->
                    <!--android:weightSum="4">-->

                    <!--<android.support.v7.widget.AppCompatTextView-->
                        <!--android:layout_marginTop="12dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="0dp"-->
                        <!--android:layout_weight="1"-->
                        <!--android:gravity="center_vertical|center|bottom"-->
                        <!--android:text="PriorXY"-->
                        <!--android:textColor="@color/textColor"-->
                        <!--android:textSize="10dp"-->
                        <!--android:textStyle="bold" />-->

                    <!--<android.support.v7.widget.AppCompatTextView-->
                        <!--android:layout_marginTop="2dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="0dp"-->
                        <!--android:layout_weight="1"-->
                        <!--android:gravity="center_vertical|center|bottom"-->
                        <!--android:text="123"-->
                        <!--android:textColor="@color/lineBlue"-->
                        <!--android:textSize="10dp" />-->

                    <!--<android.support.v7.widget.AppCompatTextView-->
                        <!--android:layout_marginTop="2dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="0dp"-->
                        <!--android:layout_weight="1"-->
                        <!--android:gravity="center_vertical|center|bottom"-->
                        <!--android:text="321"-->
                        <!--android:textColor="@color/textColor"-->
                        <!--android:textSize="9dp"/>-->

                    <!--<android.support.v7.widget.AppCompatTextView-->
                        <!--android:layout_marginTop="2dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="0dp"-->
                        <!--android:layout_weight="1"-->
                        <!--android:gravity="center_vertical|center|bottom"-->
                        <!--android:text="7dma"-->
                        <!--android:textColor="@color/textColor"-->
                        <!--android:textSize="9dp" />-->

                <!--</LinearLayout>-->
                <!--<LinearLayout-->
                    <!--android:paddingTop="16dp"-->
                    <!--android:layout_width="0dp"-->
                    <!--android:layout_height="match_parent"-->
                    <!--android:layout_weight="1"-->
                    <!--android:orientation="vertical"-->
                    <!--android:weightSum="4">-->

                    <!--<android.support.v7.widget.AppCompatTextView-->
                        <!--android:layout_marginTop="12dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="0dp"-->
                        <!--android:layout_weight="1"-->
                        <!--android:gravity="center_vertical|center|bottom"-->
                        <!--android:text="HealthCare"-->
                        <!--android:textColor="@color/textColor"-->
                        <!--android:textSize="10dp"-->
                        <!--android:textStyle="bold" />-->

                    <!--<android.support.v7.widget.AppCompatTextView-->

                        <!--android:layout_marginTop="2dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="0dp"-->
                        <!--android:layout_weight="1"-->
                        <!--android:gravity="center_vertical|center|bottom"-->
                        <!--android:text="123"-->
                        <!--android:textColor="@color/lineBlue"-->
                        <!--android:textSize="11dp" />-->

                    <!--<android.support.v7.widget.AppCompatTextView-->
                        <!--android:layout_marginTop="2dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="0dp"-->
                        <!--android:layout_weight="1"-->
                        <!--android:gravity="center_vertical|center|bottom"-->
                        <!--android:text="321"-->
                        <!--android:textColor="@color/textColor"-->
                        <!--android:textSize="9dp"/>-->

                    <!--<android.support.v7.widget.AppCompatTextView-->
                        <!--android:layout_marginTop="2dp"-->
                        <!--android:layout_width="match_parent"-->
                        <!--android:layout_height="0dp"-->
                        <!--android:layout_weight="1"-->
                        <!--android:gravity="center_vertical|center|bottom"-->
                        <!--android:text="7dma"-->
                        <!--android:textColor="@color/textColor"-->
                        <!--android:textSize="9dp" />-->

                <!--</LinearLayout>-->
            <!--</LinearLayout>-->

        <!--</android.support.v7.widget.Toolbar>-->

    <!--</android.support.design.widget.AppBarLayout>-->

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:orientation="vertical"
            >
            // Scroll View
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_weight="3"
                android:orientation="vertical">

                <android.support.v4.widget.NestedScrollView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:fillViewport="true"
                    android:isScrollContainer="true"
                    app:layout_behavior="com.evs.demo.layout.FixedScrollingViewBehavior">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:background="@color/chartlayoutBgcolor"
                        android:descendantFocusability="blocksDescendants"
                        android:orientation="vertical">

                        // Home and save button //

                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="34dp"
                            android:layout_marginLeft="4dp"
                            android:layout_marginTop="10dp"
                            android:layout_marginRight="4dp"
                            android:background="@color/topbarColor"
                            android:orientation="horizontal"
                            android:weightSum="4">

                            <android.support.v7.widget.AppCompatTextView
                                android:layout_width="0dp"
                                android:layout_height="match_parent"
                                android:layout_weight="1" />

                            <android.support.v7.widget.AppCompatImageView
                                android:layout_width="0dp"
                                android:layout_height="25dp"
                                android:layout_gravity="center_vertical|right"
                                android:layout_weight="1"
                                android:paddingLeft="10dp"
                                app:srcCompat="@drawable/ic_icon_home" />

                            <android.support.v7.widget.AppCompatImageView
                                android:layout_width="0dp"
                                android:layout_height="25dp"
                                android:layout_gravity="center_vertical|left"
                                android:layout_weight="1"
                                android:paddingRight="10dp"
                                app:srcCompat="@drawable/ic_icon_save" />

                            <android.support.v7.widget.AppCompatTextView
                                android:layout_width="0dp"
                                android:layout_height="match_parent"
                                android:layout_weight="1" />

                        </LinearLayout>

                        // First chart //

                        <RelativeLayout
                            android:layout_width="match_parent"
                            android:layout_height="256dp"
                            android:layout_marginLeft="10dp"
                            android:layout_marginTop="0dp"
                            android:layout_marginRight="10dp"
                            android:layout_marginBottom="5dp">


                            <com.highsoft.highcharts.Core.HIChartView
                                android:id="@+id/hc"
                                android:layout_width="match_parent"
                                android:layout_height="match_parent" />

                            <RelativeLayout
                                android:layout_width="match_parent"
                                android:layout_height="20dp"
                                android:layout_alignEnd="@+id/hc"
                                android:layout_marginTop="4dp"
                                android:layout_marginRight="4dp"
                                android:gravity="right">


                                <android.support.v7.widget.AppCompatTextView
                                    android:id="@+id/Day7"
                                    android:layout_width="26dp"
                                    android:layout_height="20dp"
                                    android:layout_toLeftOf="@id/Border1"
                                    android:gravity="center_vertical|center"
                                    android:padding="1dp"
                                    android:text="7D"
                                    android:textSize="10sp"
                                    android:textStyle="bold" />

                                <android.support.v7.widget.AppCompatTextView
                                    android:id="@+id/Border1"
                                    android:layout_width="1dp"
                                    android:layout_height="20dp"
                                    android:layout_toLeftOf="@id/Day14"
                                    android:background="@color/lineOrange"
                                    android:padding="1dp" />


                                <android.support.v7.widget.AppCompatTextView
                                    android:id="@+id/Day14"
                                    android:layout_width="26dp"
                                    android:layout_height="20dp"
                                    android:layout_toLeftOf="@id/Border2"
                                    android:gravity="center_vertical|center"
                                    android:padding="1dp"
                                    android:text="14D"
                                    android:textSize="10sp"
                                    android:textStyle="bold" />


                                <android.support.v7.widget.AppCompatTextView
                                    android:id="@+id/Border2"
                                    android:layout_width="1dp"
                                    android:layout_height="20dp"
                                    android:layout_toLeftOf="@id/Day21"
                                    android:background="@color/lineOrange"
                                    android:padding="1dp" />


                                <android.support.v7.widget.AppCompatTextView
                                    android:id="@+id/Day21"
                                    android:layout_width="26dp"
                                    android:layout_height="20dp"
                                    android:layout_alignParentTop="true"
                                    android:layout_alignParentRight="true"
                                    android:gravity="center_vertical|center"
                                    android:padding="1dp"
                                    android:text="21D"
                                    android:textSize="10sp"
                                    android:textStyle="bold" />

                            </RelativeLayout>

                        </RelativeLayout>

                        // Second chart //

                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="256dp"
                            android:layout_marginLeft="10dp"
                            android:layout_marginTop="5dp"
                            android:layout_marginRight="10dp"
                            android:layout_marginBottom="0dp"
                            android:orientation="vertical">

                            <com.highsoft.highcharts.Core.HIChartView
                                android:id="@+id/hc1"
                                android:layout_width="match_parent"
                                android:layout_height="match_parent" />
                        </LinearLayout>

                        // Last label //
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="40dp"
                            android:layout_marginLeft="4dp"
                            android:layout_marginRight="4dp"
                            android:layout_marginBottom="2dp"
                            android:background="@android:color/transparent"
                            android:paddingTop="5dp">

                            <TextView
                                android:layout_width="match_parent"
                                android:layout_height="match_parent"
                                android:lines="2"
                                android:text="(To normalize weekday trend, Prior year = Current day-364 Example Monday VS Monday last year) "
                                android:textColor="@color/lineGreen"
                                android:textSize="@dimen/graphText" />
                        </LinearLayout>

                    </LinearLayout>


                </android.support.v4.widget.NestedScrollView>

            </LinearLayout>

        </LinearLayout>

    <!--<android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"-->
        <!--xmlns:app="http://schemas.android.com/apk/res-auto"-->
        <!--xmlns:tools="http://schemas.android.com/tools"-->
        <!--android:id="@+id/NavigationDrawer1"-->
        <!--android:layout_width="match_parent"-->
        <!--android:layout_height="match_parent"-->
        <!--android:layout_gravity="start|left"-->
        <!--android:fitsSystemWindows="true"-->
        <!--tools:openDrawer="start">-->

    <!--<LinearLayout-->
            <!--android:id="@+id/Nav_Menu1"-->
            <!--android:layout_width="250dp"-->
            <!--android:layout_height="match_parent"-->
            <!--android:layout_gravity="start|left"-->
            <!--android:layout_marginTop="75dp"-->
            <!--android:accessibilityHeading="false"-->
            <!--android:fitsSystemWindows="true"-->
            <!--android:orientation="vertical"-->
            <!--android:background="@color/lineGray">-->

            <!--<LinearLayout-->
                <!--android:id="@+id/homeMenu2"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="match_parent"-->
                <!--android:orientation="vertical">-->

                <!--<include-->
                    <!--layout="@layout/homemenu"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="match_parent" />-->

            <!--</LinearLayout>-->

            <!--<LinearLayout-->
                <!--android:id="@+id/homeMenu3"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="match_parent"-->
                <!--android:orientation="vertical">-->

                <!--<include-->
                    <!--layout="@layout/optionmenu"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="match_parent" />-->

            <!--</LinearLayout>-->


            <!--<LinearLayout-->
                <!--android:id="@+id/homeMenu4"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="match_parent"-->
                <!--android:orientation="vertical">-->

                <!--<include-->
                    <!--layout="@layout/optionmenu"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="match_parent" />-->

            <!--</LinearLayout>-->

            <!--<LinearLayout-->
                <!--android:id="@+id/homeMenu5"-->
                <!--android:layout_width="match_parent"-->
                <!--android:layout_height="match_parent"-->
                <!--android:orientation="vertical"-->
                <!--android:fitsSystemWindows="true">-->

                <!--<include-->
                    <!--layout="@layout/homemenu"-->
                    <!--android:layout_width="match_parent"-->
                    <!--android:layout_height="match_parent" />-->

            <!--</LinearLayout>-->

        <!--</LinearLayout>-->

    <!--</android.support.v4.widget.DrawerLayout>-->

    <android.support.design.widget.BottomNavigationView
        android:id="@+id/navigationBar"
        android:layout_width="match_parent"
        android:layout_height="42dp"
        android:layout_gravity="bottom"
        android:background="@color/lineGray"
        app:menu="@menu/bottom_navigation"
        app:labelVisibilityMode="unlabeled">
    </android.support.design.widget.BottomNavigationView>

</LinearLayout>
