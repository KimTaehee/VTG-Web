/**
 * 
 */
$.urlParam = function(name){
    var results = new RegExp('[\?&amp;]' + name + '=([^&amp;#]*)').exec(window.location.href);
    return results[1] || 0;
};
 
// example.com?param1=name&amp;param2=&amp;id=6
$.urlParam('param1'); // name
$.urlParam('vid');        // 6
$.urlParam('param2');   // null