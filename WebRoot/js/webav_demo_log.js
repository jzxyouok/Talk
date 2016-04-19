//日志对象
var log = new function () {

    this.error = function (logStr) {
        try {
            console.error(logStr);
        } catch (e) {
        }
    };
    this.warn = function (logStr) {
        try {
            console.warn(logStr);
        } catch (e) {
        }
    };
    this.info = function (logStr) {
        try {
            console.info(logStr);
        } catch (e) {
        }
    };
    this.debug = function (logStr) {
        try {
            console.debug(logStr);
        } catch (e) {
        }
    };
};
