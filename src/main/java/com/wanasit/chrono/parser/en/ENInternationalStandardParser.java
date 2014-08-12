package com.wanasit.chrono.parser.en;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wanasit.chrono.ChronoOption;
import com.wanasit.chrono.ParsedDateComponent;
import com.wanasit.chrono.ParsedResult;
import com.wanasit.chrono.ParsedDateComponent.Components;
import com.wanasit.chrono.parser.ParserAbstract;

public class ENInternationalStandardParser extends ParserAbstract {
    
    @Override
    protected Pattern pattern() {
        return Pattern.compile("([0-9]{4})\\-([0-9]{1,2})\\-([0-9]{1,2})(T|\\W|$)", Pattern.CASE_INSENSITIVE);
    }
    
    @Override
    protected ParsedResult extract(String text, Date refDate, Matcher matcher, ChronoOption option) {
        
        ParsedResult result = new ParsedResult();
        result.text  = matcher.group();
        result.text  = result.text.substring(0, result.text.length() - matcher.group(4).length());
        
        result.index = matcher.start();
        
        result.start = new ParsedDateComponent();
        result.start.assign(Components.Year, Integer.parseInt(matcher.group(1)));
        result.start.assign(Components.Month, Integer.parseInt(matcher.group(2)));
        result.start.assign(Components.DayOfMonth, Integer.parseInt(matcher.group(3)));
        
        return result;
    }
}
