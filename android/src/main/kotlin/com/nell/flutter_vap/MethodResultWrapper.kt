package com.nell.flutter_vap

class MethodResultWrapper(private val methodResult: MethodChannel.Result) : MethodChannel.Result {
    private val handler: Handler = Handler(Looper.getMainLooper())

    override fun success(result: Any?) {
        handler.post {
            methodResult.success(result)
        }
    }

    override fun error(errorCode: String, errorMessage: String?, errorDetails: Any?) {
        handler.post {
            methodResult.error(errorCode, errorMessage, errorDetails)
        }
    }

    override fun notImplemented() {
        handler.post {
            methodResult.notImplemented()
        }
    }
}